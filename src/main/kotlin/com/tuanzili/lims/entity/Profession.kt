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
 * @since 2021-03-09
 */
@TableName("`profession`")
@ApiModel(value="Profession对象", description="")
data class Profession(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "专业名称")
        var name: String = "",
        @ApiModelProperty(value = "简介")
        var synopsis: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = "",
        @ApiModelProperty(value = "学院ID")
        var collegeId: Long = 0,
        @ApiModelProperty(value = "学院名称")
        var collegeName: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var name: String? = null,
                var synopsis: String? = null,
                var remark: String? = null,
                var collegeId: Long? = null,
                var collegeName: String? = null
    ) : Entity.Updater<Profession>(){
        override val entityClass: Class<Profession> = Profession::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val NAME : String = "name"
        const val SYNOPSIS : String = "synopsis"
        const val REMARK : String = "remark"
        const val COLLEGE_ID : String = "college_id"
        const val COLLEGE_NAME : String = "college_name"
    }

    override fun toString(): String {
        return """
            `{
                `"id":"$id",
                `"createdDate":"${createdDate.formatting()}",
                `"updatedDate":"${updatedDate.formatting()}",
                `"deletedDate":"${deletedDate.formatting()}",
                `"deleted":$deleted,
                `"creatorId":$creatorId,
                `"updaterId":$updaterId,
                `"name":"$name",
                `"synopsis":"$synopsis",
                `"remark":"$remark",
                `"collegeId":$collegeId,
                `"collegeName":"$collegeName"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
