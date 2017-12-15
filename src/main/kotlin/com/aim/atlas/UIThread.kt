package com.aim.atlas.demo

import io.reactivex.Scheduler
import com.aim.atlas.domain.PostExecutionThread
import io.reactivex.schedulers.Schedulers


class UiThread constructor() : PostExecutionThread {

    override fun getScheduler(): Scheduler {
        return Schedulers.single()
    }
}