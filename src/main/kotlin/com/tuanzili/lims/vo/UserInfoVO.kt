package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.User
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "User对象", description = "用户")
data class UserInfoVO(
        @JsonIgnore
        val user: User,

        @ApiModelProperty("学号、工号")
        val id: String = user.id,

        @ApiModelProperty("学号、工号")
        val phone: String = user.username,

        @ApiModelProperty("用户头像")
        val avatar: String = user.avatar,

        @ApiModelProperty("生日")
        val birthday: String = user.birthday,

        @ApiModelProperty("生日")
        val email: String = user.email,

        @ApiModelProperty("昵称")
        val nickname: String = user.nickname,

        @ApiModelProperty("用户账户启用状态")
        val status: Int = user.status

)