package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.Equipment
import com.tuanzili.lims.mapper.EquipmentMapper
import com.tuanzili.lims.service.EquipmentService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 * 设备信息表 服务实现类
 *
 * @author 李登程
 * @since 2021-04-15
 */
@Service
class EquipmentServiceImpl : KtServiceImpl<EquipmentMapper, Equipment>(), EquipmentService {
    override val emptyEntity: Equipment = Equipment()
}
