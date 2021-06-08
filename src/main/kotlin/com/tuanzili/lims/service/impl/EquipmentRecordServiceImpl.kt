package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.EquipmentRecord
import com.tuanzili.lims.mapper.EquipmentRecordMapper
import com.tuanzili.lims.service.EquipmentRecordService
import com.jxpanda.common.base.KtServiceImpl
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.entity.Equipment
import com.tuanzili.lims.service.EquipmentService
import com.tuanzili.lims.vo.EquipmentRecordVo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-04-15
 */
@Service
class EquipmentRecordServiceImpl(
    private val equipmentService: EquipmentService
) : KtServiceImpl<EquipmentRecordMapper, EquipmentRecord>(), EquipmentRecordService {

    override val emptyEntity: EquipmentRecord = EquipmentRecord()

    override fun selectEquipmentList(seeker: Seeker<EquipmentRecord>): Pagination<EquipmentRecordVo> {
        val pagination = pagination(seeker)
        if (pagination.records.isNullOrEmpty()) {
            return Pagination()
        }
        val equipmentRecordList = pagination.records
        val equipmentIds = equipmentRecordList.map { it.equipmentId }
        val equipmentMap = equipmentService.selectListByIds(equipmentIds).associateBy { it.id }
        return pagination.map {
            EquipmentRecordVo(
                equipmentRecord = it,
                equipment = equipmentMap.getOrDefault(it.equipmentId.toString(), Equipment())
            )
        }
    }

    override fun insertEquipmentRecord(equipmentRecord: EquipmentRecord): Boolean {
        if (equipmentRecord.type == 3) {
            return save(equipmentRecord)
        }
       return updateEquipment(equipmentRecord)
    }
    @Transactional(rollbackFor = [Exception::class])
    fun updateEquipment(equipmentRecord: EquipmentRecord): Boolean {
        var success: Boolean=false
        val equipmentId = equipmentRecord.equipmentId
        val balance = equipmentRecord.balance
        if (balance == BigDecimal.ZERO) {
            return true
        }

        val equipment = equipmentService.selectById(equipmentId)
        var number: BigDecimal = equipment.number.add(balance)
        if (number < BigDecimal.ZERO) {
            number = BigDecimal.ZERO
        }
        success =equipmentService.updateById(Equipment.Updater().apply {
            this.id = equipmentId.toString()
            this.number = number
        })
        if (success){
            equipmentRecord.number=equipment.number
            success= save(equipmentRecord)
        }

        return success
    }

}
