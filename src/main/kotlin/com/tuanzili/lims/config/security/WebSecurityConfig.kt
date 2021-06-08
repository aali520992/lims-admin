package com.tuanzili.lims.config.security


import com.tuanzili.lims.config.common.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

/**
 * 拦截器配置
 */
@Configuration
//启用Spring Security的Web安全支持
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig(
    @Lazy
    private val authService: AuthService,
    private val jwtAuthenticationFilter: JWTAuthenticationFilter
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    @Throws(Exception::class)
    override fun authenticationManager(): AuthenticationManager = super.authenticationManager()

    @Autowired
    @Throws(Exception::class)
    fun configureAuthentication(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder
            // 设置UserDetailsService
            .userDetailsService(authService)
            // 使用BCrypt进行密码的hash
            .passwordEncoder(passwordEncoder())
    }

    //方哪些URL路径应该被保护，哪些不应该。
    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            /**
             * 添加 CSRF 支持，使用WebSecurityConfigurerAdapter时，默认启用
             * 由于使用的是JWT，我们这里不需要csrf
             */
            .csrf().disable()
            // 基于token，所以不需要session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            /**
             * 允许基于使用HttpServletRequest限制访问
             */
            .and().authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            // 允许对于网站静态资源的无授权访问
            .antMatchers(
                HttpMethod.GET,
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.jpg",
                "/**/*.png"
            ).permitAll()
            // 允许访问
            .antMatchers(
                "/auth/**",
                "/pdd/**",
                "/equipmentRecord/**",
                "/equipment/**",
                "/lab/**",
                "/upload/**",
                "/room/**",
                "/profession/**",
                "/college/**",
                "/file/**",
                "/user/**"
            ).permitAll()
            // 放行swagger的相关资源
            .antMatchers(
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/csrf/**"
            ).permitAll()
            // 除上面外的所有请求全部需要鉴权认证
            .antMatchers(

            ).authenticated()
            .anyRequest().authenticated()

        // 禁用缓存
        httpSecurity.headers().cacheControl()

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

    }

}