package com.tuanzili.lims.service

import com.tuanzili.lims.entity.Lab
import com.jxpanda.common.base.KtService

/**
 * 实验室信息表 服务类
 *
 * @author 李登程
 * @since 2021-03-10
 */
interface LabService : KtService<Lab>{

   fun insertLabByAdmin(lab: Lab):Boolean
}
