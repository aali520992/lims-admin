package com.tuanzili.lims.service

import com.tuanzili.lims.entity.College
import com.jxpanda.common.base.KtService
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.vo.CollegeInfoVo

/**
 *  服务类
 *
 * @author 李登程
 * @since 2021-03-08
 */
interface CollegeService : KtService<College>{

   fun collegeList(seeker: Seeker<College>): Pagination<CollegeInfoVo>
}
