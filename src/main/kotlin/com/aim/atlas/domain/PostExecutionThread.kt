package com.aim.atlas.domain

import io.reactivex.Scheduler

interface PostExecutionThread {
    /**
     * This method returns the current scheduler
     */
    fun getScheduler() : Scheduler

}