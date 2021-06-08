package com.tuanzili.lims.controller.param

import com.tuanzili.lims.entity.User

class AuthParam {
    data class LoginParam(
        val username: String,
        val password: String
    )
    data class Param(
        val user: User,
        val token: String
    )
}