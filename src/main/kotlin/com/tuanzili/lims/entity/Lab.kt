package com.tuanzili.lims.entity

import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 实验室信息表
 *
 * @author 李登程
 * @since 2021-03-10
 */
@TableName("`lab`")
@ApiModel(value="Lab对象", description="实验室信息表")
data class Lab(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "实验室名称")
        var name: String = "",
        @ApiModelProperty(value = "状态（0：开放，1：禁用，2：使用）")
        var status: Int = 0,
        @ApiModelProperty(value = "地址")
        var address: String = "",
        @ApiModelProperty(value = "介绍")
        var introduce: String = "",
        @ApiModelProperty(value = "学院ID ")
        var collegeId: Long = 0,
        @ApiModelProperty(value = "管理员ID")
        var adminId: Long = 0,
        @ApiModelProperty(value = "备注")
        var remark: String = "",
        @ApiModelProperty(value = "学院名称")
        var collegeName: String = "",
        @ApiModelProperty(value = "管理员名称")
        var adminName: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var name: String? = null,
                var status: Int? = null,
                var address: String? = null,
                var introduce: String? = null,
                var collegeId: Long? = null,
                var adminId: Long? = null,
                var remark: String? = null,
                var collegeName: String? = null,
                var adminName: String? = null
    ) : Entity.Updater<Lab>(){
        override val entityClass: Class<Lab> = Lab::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val NAME : String = "name"
        const val STATUS : String = "status"
        const val ADDRESS : String = "address"
        const val INTRODUCE : String = "introduce"
        const val COLLEGE_ID : String = "college_id"
        const val ADMIN_ID : String = "admin_id"
        const val REMARK : String = "remark"
        const val COLLEGE_NAME : String = "college_name"
        const val ADMIN_NAME : String = "admin_name"
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
                `"status":$status,
                `"address":"$address",
                `"introduce":"$introduce",
                `"collegeId":$collegeId,
                `"adminId":$adminId,
                `"remark":"$remark",
                `"collegeName":"$collegeName",
                `"adminName":"$adminName"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
