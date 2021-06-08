package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.RoomProjectMap
import com.tuanzili.lims.mapper.RoomProjectMapMapper
import com.tuanzili.lims.service.RoomProjectMapService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-03-08
 */
@Service
class RoomProjectMapServiceImpl : KtServiceImpl<RoomProjectMapMapper, RoomProjectMap>(), RoomProjectMapService {
    override val emptyEntity: RoomProjectMap = RoomProjectMap()
}
