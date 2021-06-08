package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.College
import io.swagger.annotations.ApiModelProperty

class CollegeVo (
    @JsonIgnore
    val college: College = College(),


    @ApiModelProperty("学院名称")
    val value: String =college.name,
    @ApiModelProperty("学院ID")
    val id: String =college.id
)