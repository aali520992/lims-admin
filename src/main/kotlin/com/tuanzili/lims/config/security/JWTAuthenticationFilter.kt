package com.tuanzili.lims.config.security

import com.tuanzili.lims.config.common.Token
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JWTAuthenticationFilter : OncePerRequestFilter() {

    companion object {
        private const val PARAM_IP = "ip"
        private const val PARAM_DEVICE_ID = "deviceId"
        private const val PARAM_CLIENT = "client"
        val SYSTEM_PARAM = listOf(PARAM_IP, PARAM_DEVICE_ID, PARAM_CLIENT)
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authToken = request.getHeader(HttpHeaders.AUTHORIZATION)

        // 获取请求参数
        val param = HashMap(request.parameterMap)
        val requestWrapper = JwtRequestWrapper(request, param)

        // 参数中注入IP
        param[PARAM_IP] = arrayOf(getIP(request))

        // 取出设备码和客户端来源，注入到后续参数中
        param[PARAM_DEVICE_ID] = arrayOf(request.getHeader("Device-ID"))
        param[PARAM_CLIENT] = arrayOf(request.getHeader("Client"))

        if (!authToken.isNullOrEmpty()) {
            val token = Token.validate(authToken)
            if (token.effective && SecurityContextHolder.getContext().authentication == null) {
                // 我们采用的是RSA256签名机制，安全性是比较高的，因此如果验签通过，直接使用jwt中的数据，不需要重复查询数据库
                val user = token.toUser()

                val authentication = UsernamePasswordAuthenticationToken(user, "N/A", token.authorities.map { GrantedAuthority { it } })
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication

                // 注入userId到参数中
                param["userId"] = arrayOf(token.userId)
            }
        }
        filterChain.doFilter(requestWrapper, response)
    }

    private fun getIP(request: HttpServletRequest): String {

        var ip = request.getHeader("x-forwarded-for")

        if (ip.isNullOrBlank() || "unknown".equals(ip, true)) {
            ip = request.getHeader("Proxy-Client-IP")
        }
        if (ip.isNullOrBlank() || "unknown".equals(ip, true)) {
            ip = request.getHeader("WL-Proxy-Client-IP")
        }
        if (ip.isNullOrBlank() || "unknown".equals(ip, true)) {
            ip = request.remoteAddr
        }
        return if ("0:0:0:0:0:0:0:1" == ip) {
            "127.0.0.1"
        } else {
            ip
        }

    }

}