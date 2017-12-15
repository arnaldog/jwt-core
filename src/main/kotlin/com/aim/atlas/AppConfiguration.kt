package com.aim.atlas
import com.aim.atlas.data.executor.JobExecutor
import com.aim.atlas.demo.UiThread
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
@EnableJpaRepositories
class AppConfiguration {
    @Bean fun jobExecutor() = JobExecutor()
    @Bean fun uiThread() = UiThread()

    // Spring secure
    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}