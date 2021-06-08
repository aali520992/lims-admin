package com.tuanzili.lims.controller.param


import com.tuanzili.lims.entity.Lab
import com.tuanzili.lims.entity.User
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

class UpdateParam {

    @ApiModel(value = "UpdateAdmin参数", description = "管理员修改")
    data class UserParam(
        @ApiModelProperty(value = "id")
        val id: String,
        @ApiModelProperty(value = "账户启用状态")
        val status: Int? = 2

        ) {
        fun toUpdater(): User.Updater {
            val param = this
            return User.Updater().apply {
                this.id = param.id
                if (param.status == 2 || param.status == null) {
                    this.password = "password"
                } else {
                    this.status = param.status
                }
                this.updatedDate = LocalDateTime.now()

            }
        }
    }



    @ApiModel(value = "UpdateAdmin参数", description = "实验室修改")
    data class LabParam(
        @ApiModelProperty(value = "id")
        val id: String,
        @ApiModelProperty(value = "账户启用状态")
        val status: Int? = 2

        ) {
        fun toUpdater(): Lab.Updater {
            val param = this
            return Lab.Updater().apply {
                this.id = param.id
                this.status = param.status
                this.updatedDate = LocalDateTime.now()
            }
        }
    }


}
