package com.tuanzili.lims.entity

import java.math.BigDecimal
import com.jxpanda.common.base.Entity
import java.time.LocalDateTime
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
@TableName("`project`")
@ApiModel(value="Project对象", description="")
data class Project(
        @ApiModelProperty(value = "实验名称")
        var name: String = "",
        @ApiModelProperty(value = "所属学年")
        var academicYear: String = "",
        @ApiModelProperty(value = "学期（0：第一学起，1：第二学期）")
        var semester: Int = 0,
        @ApiModelProperty(value = "实验状态（0：即将开课，1：进行中，2：已结束）")
        var status: Int = 0,
        @ApiModelProperty(value = "必修类别（0：选修，1：必修）")
        var category: String = "",
        @ApiModelProperty(value = "开放角色（0：学院，1：学生，2：教师，3教师学生）")
        var role: String = "",
        @ApiModelProperty(value = "实验课程属性（0： 一般课程，1：主要课程）")
        var property: String = "",
        @ApiModelProperty(value = "学时")
        var period: BigDecimal = BigDecimal(0),
        @ApiModelProperty(value = "学分")
        var creditHour: BigDecimal = BigDecimal(0),
        @ApiModelProperty(value = "评分标准")
        var scaleMarks: String = "",
        @ApiModelProperty(value = "报告要求")
        var reportMarks: String = "",
        @ApiModelProperty(value = "上课要求")
        var classMarks: String = "",
        @ApiModelProperty(value = "教学方法")
        var teachMeth: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = "",
        @ApiModelProperty(value = "实验开课时间")
        var schoolDate: LocalDateTime = LocalDateTime.now(),
        @ApiModelProperty(value = "课程说明")
        var explain: String = "",
        @ApiModelProperty(value = "简介")
        var synopsis: String = "",
        @ApiModelProperty(value = "实验内容")
        var content: String = "",
        @ApiModelProperty(value = "实验目的")
        var effect: String = "",
        @ApiModelProperty(value = "实验要求")
        var require: String = ""
) : Entity() {

    data class Updater(
                var name: String? = null,
                var academicYear: String? = null,
                var semester: Int? = null,
                var status: Int? = null,
                var category: String? = null,
                var role: String? = null,
                var property: String? = null,
                var period: BigDecimal? = null,
                var creditHour: BigDecimal? = null,
                var scaleMarks: String? = null,
                var reportMarks: String? = null,
                var classMarks: String? = null,
                var teachMeth: String? = null,
                var remark: String? = null,
                var schoolDate: LocalDateTime? = null,
                var explain: String? = null,
                var synopsis: String? = null,
                var content: String? = null,
                var effect: String? = null,
                var require: String? = null
    ) : Entity.Updater<Project>(){
        override val entityClass: Class<Project> = Project::class.java
    }

    companion object {
        const val NAME : String = "name"
        const val ACADEMIC_YEAR : String = "academic_year"
        const val SEMESTER : String = "semester"
        const val STATUS : String = "status"
        const val CATEGORY : String = "category"
        const val ROLE : String = "role"
        const val PROPERTY : String = "property"
        const val PERIOD : String = "period"
        const val CREDIT_HOUR : String = "credit_hour"
        const val SCALE_MARKS : String = "scale_marks"
        const val REPORT_MARKS : String = "report_marks"
        const val CLASS_MARKS : String = "class_marks"
        const val TEACH_METH : String = "teach_meth"
        const val REMARK : String = "remark"
        const val SCHOOL_DATE : String = "school_date"
        const val EXPLAIN : String = "explain"
        const val SYNOPSIS : String = "synopsis"
        const val CONTENT : String = "content"
        const val EFFECT : String = "effect"
        const val REQUIRE : String = "require"
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
                `"academicYear":"$academicYear",
                `"semester":$semester,
                `"status":$status,
                `"category":"$category",
                `"role":"$role",
                `"property":"$property",
                `"period":${period.formatting()},
                `"creditHour":${creditHour.formatting()},
                `"scaleMarks":"$scaleMarks",
                `"reportMarks":"$reportMarks",
                `"classMarks":"$classMarks",
                `"teachMeth":"$teachMeth",
                `"remark":"$remark",
                `"schoolDate":"${schoolDate.formatting()}",
                `"explain":"$explain",
                `"synopsis":"$synopsis",
                `"content":"$content",
                `"effect":"$effect",
                `"require":"$require"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
