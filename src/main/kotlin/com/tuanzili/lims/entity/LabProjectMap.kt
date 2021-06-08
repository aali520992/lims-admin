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
@TableName("`lab_project_map`")
@ApiModel(value="LabProjectMap对象", description="")
data class LabProjectMap(
        @ApiModelProperty(value = "实验室ID")
        var labId: Long = 0,
        @ApiModelProperty(value = "实验室ID")
        var projectId: Long = 0
) : Entity() {

    data class Updater(
                var labId: Long? = null,
                var projectId: Long? = null
    ) : Entity.Updater<LabProjectMap>(){
        override val entityClass: Class<LabProjectMap> = LabProjectMap::class.java
    }

    companion object {
        const val LAB_ID : String = "lab_id"
        const val PROJECT_ID : String = "project_id"
    }

    override fun toString(): String {
        return """
            `{
                `"id":"$id",
                `"createdDate":"${createdDate.formatting()}",
                `"updatedDate":"${updatedDate.formatting()}",
                `"deletedDate":"${deletedDate.formatting()}",
                `"deleted":$deleted,
                `"labId":$labId,
                `"projectId":$projectId
            `}
        """.trimMargin("`").replace("\n","")
    }
}
