package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.LabProjectMap
import com.tuanzili.lims.mapper.LabProjectMapMapper
import com.tuanzili.lims.service.LabProjectMapService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-03-08
 */
@Service
class LabProjectMapServiceImpl : KtServiceImpl<LabProjectMapMapper, LabProjectMap>(), LabProjectMapService {
    override val emptyEntity: LabProjectMap = LabProjectMap()
}
