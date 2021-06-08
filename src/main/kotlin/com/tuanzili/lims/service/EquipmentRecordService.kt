package com.tuanzili.lims.service

import com.tuanzili.lims.entity.EquipmentRecord
import com.jxpanda.common.base.KtService
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.vo.EquipmentRecordVo

/**
 *  服务类
 *
 * @author 李登程
 * @since 2021-04-15
 */
interface EquipmentRecordService : KtService<EquipmentRecord> {
    fun selectEquipmentList(seeker: Seeker<EquipmentRecord>): Pagination<EquipmentRecordVo>
    fun insertEquipmentRecord(equipmentRecord: EquipmentRecord): Boolean
}
