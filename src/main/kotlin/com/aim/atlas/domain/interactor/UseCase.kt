package com.aim.atlas.domain.interactor

import com.aim.atlas.domain.PostExecutionThread
import com.aim.atlas.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, Params> internal constructor(val threadExecutor: ThreadExecutor, val postExecutionThread: PostExecutionThread) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Builds an [Observable] which will be used when executing the current [UseCAse].
     */
    internal abstract fun buildUseCaseObservable(params: Params): Observable<T>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observable build
     * by [.buildUseCaseObservable] ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<T>, params: Params) : Observable<T> {
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())

//        addDisposable(observable.subscribeWith(observer))

        return observable
    }

    fun execute(params: Params) : Observable<T> {
        return this.buildUseCaseObservable(params)
//                .subscribeOn(Schedulers.from(threadExecutor))
//                .observeOn(postExecutionThread.getScheduler())

//        addDisposable(observable.subscribeWith(observer))
    }



    fun execute(perform: (T) -> Unit, onErrorPerform: (Throwable) -> Unit, onCompletePerform: () -> Unit, params: Params) {
        val subscriber = object : DisposableObserver<T>() {
            override fun onNext(t: T) {
                perform(t)
            }

            public override fun onStart() {
//                onStartAction()
            }


            override fun onError(t: Throwable) {
                onErrorPerform(t)
            }

            override fun onComplete() {
                onCompletePerform()
            }
        }
        this.execute(subscriber, params)
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose()
        }
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}