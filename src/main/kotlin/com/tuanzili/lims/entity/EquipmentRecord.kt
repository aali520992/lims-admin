package com.tuanzili.lims.entity

import java.math.BigDecimal
import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 
 *
 * @author 李登程
 * @since 2021-04-15
 */
@TableName("`equipment_record`")
@ApiModel(value="EquipmentRecord对象", description="")
data class EquipmentRecord(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "类型（0：耗材信息，1：出库记录，2：入库记录，3：维修信息）")
        var type: Int = 0,
        @ApiModelProperty(value = "资源余额的变化值")
        var balance: BigDecimal = BigDecimal(0.0000),
        @ApiModelProperty(value = "资源变化前")
        var number: BigDecimal = BigDecimal(0.00),
        @ApiModelProperty(value = "原因")
        var reason: String = "",
        @ApiModelProperty(value = "是否修复（0：未修复，1：已修复）")
        var isRepair: Int = 0,
        @ApiModelProperty(value = "维修时间")
        var maintainData: String = "",
        @ApiModelProperty(value = "责任人")
        var principal: String = "",
        @ApiModelProperty(value = "联系方式")
        var phone: String = "",
        @ApiModelProperty(value = "维修费用")
        var cost: BigDecimal = BigDecimal(0),
        @ApiModelProperty(value = "维修地址")
        var address: String = "",
        @ApiModelProperty(value = "设备ID")
        var equipmentId: Long = 0,
        @ApiModelProperty(value = "设备名称")
        var equipmentName: String = "",
        @ApiModelProperty(value = "实验室ID")
        var labId: Long = 0,
        @ApiModelProperty(value = "实验室名称")
        var labName: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var type: Int? = null,
                var balance: BigDecimal? = null,
                var number: BigDecimal? = null,
                var reason: String? = null,
                var isRepair: Int? = null,
                var maintainData: String? = null,
                var principal: String? = null,
                var phone: String? = null,
                var cost: BigDecimal? = null,
                var address: String? = null,
                var equipmentId: Long? = null,
                var equipmentName: String? = null,
                var labId: Long? = null,
                var labName: String? = null,
                var remark: String? = null
    ) : Entity.Updater<EquipmentRecord>(){
        override val entityClass: Class<EquipmentRecord> = EquipmentRecord::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val TYPE : String = "type"
        const val BALANCE : String = "balance"
        const val NUMBER : String = "number"
        const val REASON : String = "reason"
        const val IS_REPAIR : String = "is_repair"
        const val MAINTAIN_DATA : String = "maintain_data"
        const val PRINCIPAL : String = "principal"
        const val PHONE : String = "phone"
        const val COST : String = "cost"
        const val ADDRESS : String = "address"
        const val EQUIPMENT_ID : String = "equipment_id"
        const val EQUIPMENT_NAME : String = "equipment_name"
        const val LAB_ID : String = "lab_id"
        const val LAB_NAME : String = "lab_name"
        const val REMARK : String = "remark"
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
                `"balance":${balance.formatting()},
                `"number":${number.formatting()},
                `"reason":"$reason",
                `"isRepair":$isRepair,
                `"maintainData":"$maintainData",
                `"principal":"$principal",
                `"phone":"$phone",
                `"cost":${cost.formatting()},
                `"address":"$address",
                `"equipmentId":$equipmentId,
                `"equipmentName":"$equipmentName",
                `"labId":$labId,
                `"labName":"$labName",
                `"remark":"$remark"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
