package com.tuanzili.lims.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.jxpanda.common.utils.JacksonUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JacksonConfig {

    /**
     * 处理Jackson的序列化和反序列化规则
     * */
    @Bean
    fun jackson(): ObjectMapper {
        return JacksonUtil.JACKSON
    }

}