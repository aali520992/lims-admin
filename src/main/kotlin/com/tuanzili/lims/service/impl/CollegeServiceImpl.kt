package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.College
import com.tuanzili.lims.mapper.CollegeMapper
import com.tuanzili.lims.service.CollegeService
import com.jxpanda.common.base.KtServiceImpl
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.vo.CollegeInfoVo
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-03-08
 */
@Service
class CollegeServiceImpl : KtServiceImpl<CollegeMapper, College>(), CollegeService {
        override val emptyEntity: College = College()

    override fun collegeList(seeker: Seeker<College>): Pagination<CollegeInfoVo> {
        val pagination = pagination(seeker)
        if (pagination.records.isNullOrEmpty()) {
            return Pagination()
        }
        val labList = pagination.records
        val labCollegeIds=labList.map { it.collegeId }
        val labMap=selectListByIds(labCollegeIds).associateBy { it.id }
        return pagination.map {
            CollegeInfoVo(
                college = it,
                supCollege = labMap.getOrDefault(it.collegeId.toString(), College())
            )
        }
    }
}
