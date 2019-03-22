package dev.murad.acorn

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun apiDocket(): Docket {

        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.murad.acorn"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
                "Acorn REST API",
                "REST API for Acorn based on LesterLyu's Java Acorn API",
                "",
                "",
                Contact("Murad Akhundov", "www.murad.dev", "see website for email"),
                "MIT LICENSE", "https://opensource.org/licenses/MIT", Collections.emptyList())
    }
}