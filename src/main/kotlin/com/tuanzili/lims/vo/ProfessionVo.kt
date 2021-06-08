package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.Profession
import io.swagger.annotations.ApiModelProperty

class ProfessionVo (
    @JsonIgnore
    val profession: Profession = Profession(),

    @ApiModelProperty("教师姓名")
    val value: String = profession.name,
    @ApiModelProperty("教师ID")
    val id: String = profession.id

)