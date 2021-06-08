package com.tuanzili.lims.service

import com.tuanzili.lims.entity.KeyPair
import com.jxpanda.common.base.KtService

/**
 * 密钥对 服务类
 *
 * @author 李登程
 * @since 2021-03-08
 */
interface KeyPairService : KtService<KeyPair>{
    fun loginKey(): KeyPair
}
