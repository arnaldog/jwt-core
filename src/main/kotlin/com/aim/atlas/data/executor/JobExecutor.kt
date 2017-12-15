package com.aim.atlas.data.executor

import com.aim.atlas.domain.executor.ThreadExecutor
import java.util.concurrent.ThreadFactory
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class JobExecutor
constructor() : ThreadExecutor {
    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        this.threadPoolExecutor = ThreadPoolExecutor(1000, 1000, 10, TimeUnit.SECONDS,
                LinkedBlockingQueue(), JobThreadFactory())
    }

    override fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "spring_" + counter++)
        }
    }
}