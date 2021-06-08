package com.tuanzili.lims.controller.param

import com.tuanzili.lims.entity.User
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

class UserParam {
    @ApiModel(value = "UpdateUser参数", description = "用户修改")
    data class UpdateUser(
        @ApiModelProperty(value = "头像")
        val avatar: String,
        @ApiModelProperty(value = "昵称")
        val nickname: String,
        @ApiModelProperty(value = "性别")
        val gender: Int,
        @ApiModelProperty(value = "生日")
        val birthday: LocalDateTime

    ) {
        fun toUpdater(userId: String): User.Updater {
            val param = this
            return User.Updater().apply {
                this.id = userId
                this.avatar = param.avatar
                this.nickname = param.nickname
                this.birthday = param.birthday.toString()

            }
        }
    }
}