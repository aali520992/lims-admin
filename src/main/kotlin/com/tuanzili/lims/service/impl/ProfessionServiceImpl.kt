package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.Profession
import com.tuanzili.lims.mapper.ProfessionMapper
import com.tuanzili.lims.service.ProfessionService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-03-09
 */
@Service
class ProfessionServiceImpl : KtServiceImpl<ProfessionMapper, Profession>(), ProfessionService {
    override val emptyEntity: Profession = Profession()
}
