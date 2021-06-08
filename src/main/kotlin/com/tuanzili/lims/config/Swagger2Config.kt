package com.tuanzili.lims.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("com/tuanzili/lims")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tuanzili.lims.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(listOf(
                        ParameterBuilder()
                                .name("Authorization")
                                .description("登陆成功后签发的Token，除了授权类（auth）接口外，所有接口都需要携带Token才能访问")
                                .modelRef(ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()
                ))
    }

    fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("com/tuanzili/lims")
                .description("实验室管理系统")
                .termsOfServiceUrl("https://www.baidu.com")
                .version("1.0.0")
                .contact(Contact("tuanzili", "https://www.baidu.com", "3035393188@qq.com"))
                .build()
    }
}