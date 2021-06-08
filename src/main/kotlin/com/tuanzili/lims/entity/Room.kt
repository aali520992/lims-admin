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
@TableName("`room`")
@ApiModel(value="Room对象", description="")
data class Room(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "所属学年")
        var academicYear: String = "",
        @ApiModelProperty(value = "班级名称")
        var name: String = "",
        @ApiModelProperty(value = "班级简介")
        var synopsis: String = "",
        @ApiModelProperty(value = "班级地址")
        var address: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = "",
        @ApiModelProperty(value = "学院ID")
        var collegeId: Long = 0,
        @ApiModelProperty(value = "学院名称")
        var collegeName: String = "",
        @ApiModelProperty(value = "专业ID")
        var professionId: Long = 0,
        @ApiModelProperty(value = "专业名称")
        var professionName: String = "",
        @ApiModelProperty(value = "辅导员ID")
        var teacherId: Long = 0,
        @ApiModelProperty(value = "辅导员名称")
        var teacherName: String = "",
        @ApiModelProperty(value = "班主任ID")
        var classTeacherId: Long = 0,
        @ApiModelProperty(value = "班主任名称")
        var classTeacherName: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var academicYear: String? = null,
                var name: String? = null,
                var synopsis: String? = null,
                var address: String? = null,
                var remark: String? = null,
                var collegeId: Long? = null,
                var collegeName: String? = null,
                var professionId: Long? = null,
                var professionName: String? = null,
                var teacherId: Long? = null,
                var teacherName: String? = null,
                var classTeacherId: Long? = null,
                var classTeacherName: String? = null
    ) : Entity.Updater<Room>(){
        override val entityClass: Class<Room> = Room::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val ACADEMIC_YEAR : String = "academic_year"
        const val NAME : String = "name"
        const val SYNOPSIS : String = "synopsis"
        const val ADDRESS : String = "address"
        const val REMARK : String = "remark"
        const val COLLEGE_ID : String = "college_id"
        const val COLLEGE_NAME : String = "college_name"
        const val PROFESSION_ID : String = "profession_id"
        const val PROFESSION_NAME : String = "profession_name"
        const val TEACHER_ID : String = "teacher_id"
        const val TEACHER_NAME : String = "teacher_name"
        const val CLASS_TEACHER_ID : String = "class_teacher_id"
        const val CLASS_TEACHER_NAME : String = "class_teacher_name"
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
                `"academicYear":"$academicYear",
                `"name":"$name",
                `"synopsis":"$synopsis",
                `"address":"$address",
                `"remark":"$remark",
                `"collegeId":$collegeId,
                `"collegeName":"$collegeName",
                `"professionId":$professionId,
                `"professionName":"$professionName",
                `"teacherId":$teacherId,
                `"teacherName":"$teacherName",
                `"classTeacherId":$classTeacherId,
                `"classTeacherName":"$classTeacherName"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
