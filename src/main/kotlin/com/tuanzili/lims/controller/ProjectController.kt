package com.tuanzili.lims.controller

import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.entity.Project
import com.tuanzili.lims.service.ProjectService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("/project", tags = ["项目"])
@RestController()
@RequestMapping("/project")
class ProjectController(
    private val projectService: ProjectService
) {
//    @ApiOperation("项目列表")
//    @PostMapping("/projectList")
//    fun selectprojectList(): Result<List<projectVo>> {
//        return Result.ok(projectService.list().map { projectVo(it) })
//    }
    @ApiOperation("项目列表")
    @PostMapping("/list")
    fun projectList(@RequestBody seeker: Seeker<Project>): Result<Pagination<Project>> {
        return Result.ok(projectService.pagination(seeker))
    }
    @ApiOperation("添加项目")
    @PostMapping("/insert")
    fun projectList(@RequestBody project:Project): Result<Boolean> {
        return Result.ok(projectService.save(project))
    }
    @ApiOperation("添加项目")
    @PostMapping("/update")
    fun projectUpdate(@RequestBody project:Project): Result<Boolean> {
        return Result.ok(projectService.updateById(project))
    }

    @ApiOperation("根据Ids批量删除")
    @PostMapping("/delete")
    fun deleteTeacherByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(projectService.deleteByIds(ids))
    }
}