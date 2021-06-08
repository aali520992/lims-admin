package com.tuanzili.lims.controller

import com.jxpanda.common.base.Result
import com.tuanzili.lims.config.common.AuthService
import com.tuanzili.lims.config.security.JwtUser
import com.tuanzili.lims.controller.param.AuthParam
import com.tuanzili.lims.controller.param.UserParam
import com.tuanzili.lims.entity.User
import com.tuanzili.lims.service.UserService
import com.tuanzili.lims.vo.UserInfoVO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@Api("auth", tags = ["验证"])
@RestController("auth")
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService,
    private val userService: UserService
) {
    @ApiOperation("添加用户")
    @PostMapping("/insert")
    fun insertUser(@RequestBody user: User): Result<Boolean> {
        if (user.effective){
            return  Result.error("参数为空")
        }
        return Result.ok(authService.insertUser(user))
    }

    @ApiOperation("登录验证")
    @PostMapping("/login")
    fun login(ip: String, @RequestBody loginParam: AuthParam.LoginParam): Result<AuthParam.Param> {
        val (username, password) = loginParam
        val user = userService.selectByName(username)
        if (!user.effective) {
            return Result.error("请检查用户名")
        }
        val match = authService.isPasswordMatch(user.id, password)
        if (match) {
            val token=authService.loadUserByUsername(username).signature()
            return Result.ok(AuthParam.Param(user,token))
        }
        return Result.error("密码错误")
    }

    @ApiOperation(value = "token续签")
    @GetMapping("/token/renewal")
    fun tokenRenewal(userId: String): Result<String> {
        return Result.ok(JwtUser(userService.selectById(userId)).signature())
    }

    @ApiOperation(value = "用户修改详情查询")
    @PostMapping("/info")
    fun userUpdateInfo(userId: String): Result<UserInfoVO> {
        return Result.ok(UserInfoVO(userService.selectById(userId)))
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    fun updateUser(userId: String, @RequestBody updateUser: UserParam.UpdateUser): Result<Boolean> {
        return Result.ok(userService.updateById(updateUser.toUpdater(userId)))
    }

}
