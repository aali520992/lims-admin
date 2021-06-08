package com.tuanzili.lims.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.tuanzili.lims.entity.User
import com.tuanzili.lims.mapper.UserMapper
import com.tuanzili.lims.service.UserService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-04-19
 */
@Service
class UserServiceImpl : KtServiceImpl<UserMapper, User>(), UserService {
    override val emptyEntity: User = User()

    override fun selectByName(username: String): User {
        return selectOne(QueryWrapper<User>().eq(User.USERNAME, username))
    }

}
