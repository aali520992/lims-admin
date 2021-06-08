package com.tuanzili.lims.service

import com.tuanzili.lims.entity.User
import com.jxpanda.common.base.KtService

/**
 *  服务类
 *
 * @author tuanzili
 * @since 2021-04-26
 */
interface UserService : KtService<User> {
    fun selectByName(username: String): User
}
