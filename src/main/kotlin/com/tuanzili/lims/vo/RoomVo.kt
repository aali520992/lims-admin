package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.Profession
import com.tuanzili.lims.entity.Room
import io.swagger.annotations.ApiModelProperty

class RoomVo (
    @JsonIgnore
    val room: Room = Room(),

    @ApiModelProperty("班级名称")
    val value: String = room.name,
    @ApiModelProperty("班级Id")
    val id: String = room.id
)