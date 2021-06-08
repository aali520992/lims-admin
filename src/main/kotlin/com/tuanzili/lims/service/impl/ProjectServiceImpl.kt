package com.tuanzili.lims.service.impl

import com.tuanzili.lims.entity.Project
import com.tuanzili.lims.mapper.ProjectMapper
import com.tuanzili.lims.service.ProjectService
import com.jxpanda.common.base.KtServiceImpl
import org.springframework.stereotype.Service

/**
 *  服务实现类
 *
 * @author 李登程
 * @since 2021-03-08
 */
@Service
class ProjectServiceImpl : KtServiceImpl<ProjectMapper, Project>(), ProjectService {
    override val emptyEntity: Project = Project()
}
