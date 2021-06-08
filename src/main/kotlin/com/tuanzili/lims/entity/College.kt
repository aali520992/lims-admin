package com.tuanzili.lims.entity

import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 
 *
 * @author 李登程
 * @since 2021-03-08
 */
@TableName("`college`")
@ApiModel(value="College对象", description="")
data class College(
        @ApiModelProperty(value = "学院名称")
        var name: String = "",
        @ApiModelProperty(value = "状态（0：开放，1：禁用，2：使用）")
        var status: Int = 0,
        @ApiModelProperty(value = "简介")
        var synopsis: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = "",
        @ApiModelProperty(value = "上级学院ID")
        var collegeId: Long = 0
) : Entity() {

    data class Updater(
                var name: String? = null,
                var status: Int? = null,
                var synopsis: String? = null,
                var remark: String? = null,
                var collegeId: Long? = null
    ) : Entity.Updater<College>(){
        override val entityClass: Class<College> = College::class.java
    }

    companion object {
        const val NAME : String = "name"
        const val STATUS : String = "status"
        const val SYNOPSIS : String = "synopsis"
        const val REMARK : String = "remark"
        const val COLLEGE_ID : String = "college_id"
    }

    override fun toString(): String {
        return """
            `{
                `"id":"$id",
                `"createdDate":"${createdDate.formatting()}",
                `"updatedDate":"${updatedDate.formatting()}",
                `"deletedDate":"${deletedDate.formatting()}",
                `"deleted":$deleted,
                `"name":"$name",
                `"status":$status,
                `"synopsis":"$synopsis",
                `"remark":"$remark",
                `"collegeId":$collegeId
            `}
        """.trimMargin("`").replace("\n","")
    }
}
