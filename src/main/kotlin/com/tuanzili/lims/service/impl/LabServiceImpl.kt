package com.tuanzili.lims.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.tuanzili.lims.entity.Lab
import com.tuanzili.lims.mapper.LabMapper
import com.tuanzili.lims.service.LabService
import com.jxpanda.common.base.KtServiceImpl
import com.tuanzili.lims.entity.User
import com.tuanzili.lims.service.UserService
import org.springframework.stereotype.Service

/**
 * 实验室信息表 服务实现类
 *
 * @author 李登程
 * @since 2021-03-10
 */
@Service
class LabServiceImpl(
    private val userService: UserService
) : KtServiceImpl<LabMapper, Lab>(), LabService {
    override val emptyEntity: Lab = Lab()

    override fun insertLabByAdmin(lab: Lab): Boolean {
        val zero:Long=0
        if (lab.collegeId!=zero && lab.adminId==zero) {
            val adminList = userService.list(
                QueryWrapper<User>().`in`(User.COLLEGE_ID, lab.collegeId.toString()).eq(User.ROLE, 1)
                    .orderByAsc("created_date"))
            val adminIds = adminList.map { it.id }
            var adminNames = adminList.map { it.username }
            return if (adminIds.isEmpty()) {
                save(lab)
            } else {
                val labs = list(QueryWrapper<Lab>().`in`(Lab.COLLEGE_ID,lab.collegeId)).map { it.id }.size
                val admins = adminIds.size
                val num: Int = labs % admins
                save(lab.apply {
                    this.adminId = adminIds[num].toLong()
                    this.adminName = adminNames[num]
                })
            }
        }
        return save(lab)

    }

}

