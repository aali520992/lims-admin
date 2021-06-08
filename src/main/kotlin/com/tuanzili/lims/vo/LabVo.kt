package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.Lab
import com.tuanzili.lims.enumeration.EnumMap
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

@ApiModel(value = "LabVo对象", description = "实验室列表")
class LabVo(
    @JsonIgnore
    val lab: Lab = Lab(),

    @ApiModelProperty("实验室Id")
    val id: String = lab.id,
    @ApiModelProperty("教师姓名")
    val value: String = lab.name

)