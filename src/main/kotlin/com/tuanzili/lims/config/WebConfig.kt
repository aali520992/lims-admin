package com.tuanzili.lims.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    @Bean
    fun corsFilter(): CorsFilter {
        return CorsFilter(UrlBasedCorsConfigurationSource().apply {
            this.registerCorsConfiguration("/**", CorsConfiguration().apply {
                this.addAllowedOrigin("*")
                this.addAllowedHeader("*")
                this.addAllowedMethod("*")
            })
        })
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
        super.addResourceHandlers(registry)
    }

}