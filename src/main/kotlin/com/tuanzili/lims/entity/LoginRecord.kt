package com.tuanzili.lims.entity

import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 登录日志信息表
 *
 * @author 李登程
 * @since 2021-03-08
 */
@TableName("`login_record`")
@ApiModel(value="LoginRecord对象", description="登录日志信息表")
data class LoginRecord(
        @ApiModelProperty(value = "用户ID")
        var userId: Long = 0,
        @ApiModelProperty(value = "IP，使用INT存储。好处，1：节省空间，2：可以使用 INET_ATON() 函数进行IP段查询，例如：SELECT * FROM table WHERE ip BETWEEN INET_ATON('192.168.1.1') AND INET_ATON('192.168.1.100');")
        var ip: Int = 0,
        @ApiModelProperty(value = "登陆的地址")
        var address: String = "",
        @ApiModelProperty(value = "登陆来源（0：未知，1：微信公众号，2：微信小程序，3：安卓客户端，4：IOS客户端，5：web网页端）")
        var source: Int = 0
) : Entity() {

    data class Updater(
                var userId: Long? = null,
                var ip: Int? = null,
                var address: String? = null,
                var source: Int? = null
    ) : Entity.Updater<LoginRecord>(){
        override val entityClass: Class<LoginRecord> = LoginRecord::class.java
    }

    companion object {
        const val USER_ID : String = "user_id"
        const val IP : String = "ip"
        const val ADDRESS : String = "address"
        const val SOURCE : String = "source"
    }

    override fun toString(): String {
        return """
            `{
                `"id":"$id",
                `"createdDate":"${createdDate.formatting()}",
                `"updatedDate":"${updatedDate.formatting()}",
                `"deletedDate":"${deletedDate.formatting()}",
                `"deleted":$deleted,
                `"userId":$userId,
                `"ip":$ip,
                `"address":"$address",
                `"source":$source
            `}
        """.trimMargin("`").replace("\n","")
    }
}
