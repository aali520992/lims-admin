package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.Room
import com.tuanzili.lims.mapper.RoomMapper
import com.tuanzili.lims.service.RoomService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-03-09
 */
@Service
class RoomServiceImpl : KtServiceImpl<RoomMapper, Room>(), RoomService {
    override val emptyEntity: Room = Room()
}
