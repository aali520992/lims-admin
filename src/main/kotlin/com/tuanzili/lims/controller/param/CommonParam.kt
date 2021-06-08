package com.tuanzili.lims.controller.param

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

class CommonParam {
    @ApiModel(value = "Delete", description = "批量删除通用")
    data class Delete(
        @ApiModelProperty(value = "ids集合")
        val ids: List<String> = emptyList()
    )

}