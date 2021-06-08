package com.tuanzili.lims.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.tuanzili.lims.entity.KeyPair
import com.tuanzili.lims.mapper.KeyPairMapper
import com.tuanzili.lims.service.KeyPairService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 * 密钥对 服务实现类
 *
 * @author 李登程
 * @since 2021-03-08
 */
@Service
class KeyPairServiceImpl : KtServiceImpl<KeyPairMapper, KeyPair>(), KeyPairService {
    override val emptyEntity: KeyPair = KeyPair()
    override fun loginKey(): KeyPair {
        return selectOne(
            QueryWrapper<KeyPair>()
            .eq(KeyPair.TYPE, 1)
        )
    }
}
