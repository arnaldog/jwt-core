package com.aim.atlas
import com.aim.atlas.data.executor.JobExecutor
import com.aim.atlas.demo.UiThread
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.servlet.mvc.method.RequestMappingInfo.paths
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


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

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
    }
}