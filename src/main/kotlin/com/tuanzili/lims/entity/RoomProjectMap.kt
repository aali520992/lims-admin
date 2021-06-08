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
@TableName("`room_project_map`")
@ApiModel(value="RoomProjectMap对象", description="")
data class RoomProjectMap(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "课程表ID")
        var projectId: Long = 0,
        @ApiModelProperty(value = "班级ID")
        var classId: Long = 0,
        @ApiModelProperty(value = "备注")
        var remark: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var projectId: Long? = null,
                var classId: Long? = null,
                var remark: String? = null
    ) : Entity.Updater<RoomProjectMap>(){
        override val entityClass: Class<RoomProjectMap> = RoomProjectMap::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val PROJECT_ID : String = "project_id"
        const val CLASS_ID : String = "class_id"
        const val REMARK : String = "remark"
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
                `"projectId":$projectId,
                `"classId":$classId,
                `"remark":"$remark"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
