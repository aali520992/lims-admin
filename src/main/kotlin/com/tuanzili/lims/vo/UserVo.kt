package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.User
import io.swagger.annotations.ApiModelProperty


open class UserVo(
    @JsonIgnore
    private val user: User
){

    data class TeacherVo(
        @JsonIgnore
        private val user: User,

        @ApiModelProperty("教师姓名")
        val value: String = user.username,
        @ApiModelProperty("教师ID")
        val id: String = user.id

    ) : UserVo(user)


}

