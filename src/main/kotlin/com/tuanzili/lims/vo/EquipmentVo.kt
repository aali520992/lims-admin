package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.Equipment
import com.tuanzili.lims.entity.Lab
import com.tuanzili.lims.enumeration.EnumMap
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

@ApiModel(value = "EquipmentVo对象", description = "设备")
class EquipmentVo(
    @JsonIgnore
    val equipment: Equipment = Equipment(),

    @ApiModelProperty("设备Id")
    val id: String = equipment.id,
    @ApiModelProperty("设备名称")
    val value: String = equipment.name

)