package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.LoginRecord
import com.tuanzili.lims.mapper.LoginRecordMapper
import com.tuanzili.lims.service.LoginRecordService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 * 登录日志信息表 服务实现类
 *
 * @author 李登程
 * @since 2021-03-08
 */
@Service
class LoginRecordServiceImpl : KtServiceImpl<LoginRecordMapper, LoginRecord>(), LoginRecordService {
    override val emptyEntity: LoginRecord = LoginRecord()
}
