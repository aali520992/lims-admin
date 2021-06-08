package com.tuanzili.lims.config

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * Created by Geek on 2018/3/15
 */
@Configuration
@MapperScan("com.tuanzili.lims.mapper*")
class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br></br>
     * 文档：http://mp.baomidou.com<br></br>
     */
    @Bean
    fun paginationInterceptor(): PaginationInterceptor {
        return PaginationInterceptor()
    }

}
