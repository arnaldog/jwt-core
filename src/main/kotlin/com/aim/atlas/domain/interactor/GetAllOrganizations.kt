package com.aim.atlas.domain.interactor

import com.aim.atlas.domain.executor.ThreadExecutor
import com.aim.atlas.domain.Organization
import com.aim.atlas.domain.repository.OrganizationRepository
import io.reactivex.Observable
import com.aim.atlas.domain.PostExecutionThread
import org.springframework.stereotype.Component

@Component
class GetAllAccounts constructor(private val repository: OrganizationRepository,
            threadExecutor: ThreadExecutor,
            postExecutionThread: PostExecutionThread)
    : UseCase<Organization, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(unused: Unit): Observable<Organization> {
        return this.repository.getAllOrganizations()
    }
}