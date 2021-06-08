package com.tuanzili.lims.entity

import java.math.BigDecimal
import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 设备信息表
 *
 * @author 李登程
 * @since 2021-04-15
 */
@TableName("`equipment`")
@ApiModel(value="Equipment对象", description="设备信息表")
data class Equipment(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "设备型号")
        var type: Long = 0,
        @ApiModelProperty(value = "设备名称")
        var name: String = "",
        @ApiModelProperty(value = "品牌")
        var brand: String = "",
        @ApiModelProperty(value = "数量")
        var number: BigDecimal = BigDecimal(0),
        @ApiModelProperty(value = "状态（0：待维修，1：正常，2：损坏，3：危险，4：报废）")
        var status: Int = 0,
        @ApiModelProperty(value = "价格")
        var sumPrice: BigDecimal = BigDecimal(0000000000000.00),
        @ApiModelProperty(value = "单价")
        var unitPrice: BigDecimal = BigDecimal(0),
        @ApiModelProperty(value = "使用说明")
        var instructions: String = "",
        @ApiModelProperty(value = "图片")
        @TableField("Image_list")
        var imageList: String = "",
        @ApiModelProperty(value = "保质期")
        var expirationDate: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = "",
        @ApiModelProperty(value = "实验室ID")
        var labId: Long = 0,
        @ApiModelProperty(value = "实验室名称")
        var labName: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var type: Long? = null,
                var name: String? = null,
                var brand: String? = null,
                var number: BigDecimal? = null,
                var status: Int? = null,
                var sumPrice: BigDecimal? = null,
                var unitPrice: BigDecimal? = null,
                var instructions: String? = null,
                var imageList: String? = null,
                var expirationDate: String? = null,
                var remark: String? = null,
                var labId: Long? = null,
                var labName: String? = null
    ) : Entity.Updater<Equipment>(){
        override val entityClass: Class<Equipment> = Equipment::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val TYPE : String = "type"
        const val NAME : String = "name"
        const val BRAND : String = "brand"
        const val NUMBER : String = "number"
        const val STATUS : String = "status"
        const val SUM_PRICE : String = "sum_price"
        const val UNIT_PRICE : String = "unit_price"
        const val INSTRUCTIONS : String = "instructions"
        const val IMAGE_LIST : String = "Image_list"
        const val EXPIRATION_DATE : String = "expiration_date"
        const val REMARK : String = "remark"
        const val LAB_ID : String = "lab_id"
        const val LAB_NAME : String = "lab_name"
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
                `"type":$type,
                `"name":"$name",
                `"brand":"$brand",
                `"number":${number.formatting()},
                `"status":$status,
                `"sumPrice":${sumPrice.formatting()},
                `"unitPrice":${unitPrice.formatting()},
                `"instructions":"$instructions",
                `"imageList":"$imageList",
                `"expirationDate":"$expirationDate",
                `"remark":"$remark",
                `"labId":$labId,
                `"labName":"$labName"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
