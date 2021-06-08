package com.tuanzili.lims.vo


import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.College
import com.tuanzili.lims.enumeration.EnumMap
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

class CollegeInfoVo(
    @JsonIgnore
    val supCollege: College = College(),
    @JsonIgnore
    val college: College = College(),

    @ApiModelProperty("上级学院名称")
    val collegeName: String = supCollege.name,

    @ApiModelProperty("学院名称")
    val name: String = college.name,

    @ApiModelProperty("学院Id")
    val id: String = college.id,

    @ApiModelProperty("学院简介")
    val synopsis: String = supCollege.synopsis,

    @ApiModelProperty("学院状态")
    val status: Boolean = EnumMap.STATUS[supCollege.status]?.description ?: true,

    @ApiModelProperty("学院名称")
    val createdDate: LocalDateTime = supCollege.createdDate,

    @ApiModelProperty("备注")
    val remark: String = supCollege.remark

    )