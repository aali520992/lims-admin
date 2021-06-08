package com.tuanzili.lims.config.common


import com.tuanzili.lims.config.security.JwtUser
import com.tuanzili.lims.entity.User
import com.tuanzili.lims.service.LoginRecordService
import com.tuanzili.lims.service.UserService
import org.springframework.context.annotation.Lazy
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthService(
    private val loginRecordService: LoginRecordService,
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder
) : UserDetailsService {

    override fun loadUserByUsername(username: String): JwtUser {
        return JwtUser(userService.selectByName(username))
    }

    /**
     * 用户登录，成功后，签发JWT
     * */
    fun login(account: String, password: String, ip: String = "0.0.0.0"): String {
        // 使用spring-security校验数据（登录）
//        val authenticationToken = UsernamePasswordAuthenticationToken(account, password)
//        val authentication = authenticationManager.authenticate(authenticationToken)
//        SecurityContextHolder.getContext().authentication = authentication


        return loadUserByUsername(account).signature()
    }

    fun insertUser(user: User): Boolean {
        return userService.save(user.apply {
            password = user.password.passwordEncode()
        })
    }

    fun isPasswordMatch(id: String, password: String): Boolean {
        return password.isNotBlank() && userService.selectById(id).password.passwordMatches(password)
    }

    /**
     * 两个针对密码的私有扩展，方便使用
     * */
    private fun String.passwordEncode() = passwordEncoder.encode(this)

    private fun String.passwordMatches(password: String) = passwordEncoder.matches(password, this)


}