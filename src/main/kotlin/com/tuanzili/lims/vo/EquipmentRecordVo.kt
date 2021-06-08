package com.tuanzili.lims.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tuanzili.lims.entity.Equipment
import com.tuanzili.lims.entity.EquipmentRecord
import com.tuanzili.lims.entity.Lab
import com.tuanzili.lims.enumeration.EnumMap
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal
import java.time.LocalDateTime

@ApiModel(value = "EquipmentVo对象", description = "设备")
class EquipmentRecordVo(
    @JsonIgnore
    val equipment: Equipment = Equipment(),
    @JsonIgnore
    val equipmentRecord: EquipmentRecord = EquipmentRecord(),

    @ApiModelProperty(value = "设备型号")
    var type: Long = equipment.type,
    @ApiModelProperty(value = "设备名称")
    var name: String = equipment.name,
    @ApiModelProperty(value = "品牌")
    var brand: String = equipment.brand,
    @ApiModelProperty(value = "数量")
    var number: BigDecimal =equipment.number,
    @ApiModelProperty(value = "状态（0：待维修，1：正常，2：损坏，3：危险）")
    var status: Int =equipment.status,
    @ApiModelProperty(value = "价格")
    var sumPrice: BigDecimal = equipment.sumPrice,
    @ApiModelProperty(value = "单价")
    var unitPrice: BigDecimal = equipment.unitPrice,
    @ApiModelProperty(value = "变化值")

    var id: String =equipmentRecord.id,

    var createdDate: LocalDateTime =equipmentRecord.createdDate,
    var balance: BigDecimal =equipmentRecord.balance,
    @ApiModelProperty(value = "原因")
    var reason: String =equipmentRecord.reason,
    @ApiModelProperty(value = "是否修复（0：未修复，1：已修复）")
    var isRepair: Int = equipmentRecord.isRepair,
    @ApiModelProperty(value = "维修时间")
    var maintainData: String = equipmentRecord.maintainData,
    @ApiModelProperty(value = "责任人")
    var principal: String = equipmentRecord.principal,
    @ApiModelProperty(value = "联系方式")
    var phone: String = equipmentRecord.phone,
    @ApiModelProperty(value = "维修费用")
    var cost: BigDecimal = equipmentRecord.cost,
    @ApiModelProperty(value = "维修地址")
    var address: String = equipmentRecord.address,
    @ApiModelProperty(value = "设备ID")
    var equipmentId: Long = equipmentRecord.equipmentId,
    @ApiModelProperty(value = "设备名称")
    var equipmentName: String = equipmentRecord.equipmentName,
    @ApiModelProperty(value = "实验室ID")
    var labId: Long = equipmentRecord.labId,
    @ApiModelProperty(value = "实验室名称")
    var labName: String = equipmentRecord.labName,
    @ApiModelProperty(value = "备注")
    var remark: String = equipmentRecord.remark

)