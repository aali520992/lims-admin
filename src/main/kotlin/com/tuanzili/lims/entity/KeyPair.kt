package com.tuanzili.lims.entity

import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 密钥对
 *
 * @author 李登程
 * @since 2021-03-08
 */
@TableName("`key_pair`")
@ApiModel(value="KeyPair对象", description="密钥对")
data class KeyPair(
        @ApiModelProperty(value = "类型（0：未知，1：登陆密钥）")
        var type: Int = 0,
        @ApiModelProperty(value = "私钥（可能加密）")
        var private: String = "",
        @ApiModelProperty(value = "公钥（可能加密）")
        var public: String = ""
) : Entity() {

    data class Updater(
                var type: Int? = null,
                var private: String? = null,
                var public: String? = null
    ) : Entity.Updater<KeyPair>(){
        override val entityClass: Class<KeyPair> = KeyPair::class.java
    }

    companion object {
        const val TYPE : String = "type"
        const val PRIVATE : String = "private"
        const val PUBLIC : String = "public"
    }

    override fun toString(): String {
        return """
            `{
                `"id":"$id",
                `"createdDate":"${createdDate.formatting()}",
                `"updatedDate":"${updatedDate.formatting()}",
                `"deletedDate":"${deletedDate.formatting()}",
                `"deleted":$deleted,
                `"type":$type,
                `"private":"$private",
                `"public":"$public"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
