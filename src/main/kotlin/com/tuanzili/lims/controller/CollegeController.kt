package com.tuanzili.lims.controller

import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.entity.College
import com.tuanzili.lims.service.CollegeService
import com.tuanzili.lims.vo.CollegeInfoVo
import com.tuanzili.lims.vo.CollegeVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("/college", tags = ["学院"])
@RestController()
@RequestMapping("/college")
class CollegeController(
    private val collegeService: CollegeService
) {
    @ApiOperation("学院列表")
    @PostMapping("/collegeList")
    fun selectCollegeList(): Result<List<CollegeVo>> {
        return Result.ok(collegeService.list().map { CollegeVo(it) })
    }
    @ApiOperation("学院列表")
    @PostMapping("/list")
    fun collegeList(@RequestBody seeker: Seeker<College>): Result<Pagination<CollegeInfoVo>> {
        return Result.ok(collegeService.collegeList(seeker))
    }
    @ApiOperation("添加学院")
    @PostMapping("/insert")
    fun collegeList(@RequestBody college:College): Result<Boolean> {
        return Result.ok(collegeService.save(college))
    }
    @ApiOperation("添加学院")
    @PostMapping("/update")
    fun collegeUpdate(@RequestBody college:College): Result<Boolean> {
        return Result.ok(collegeService.updateById(college))
    }

    @ApiOperation("根据Ids批量删除")
    @PostMapping("/delete")
    fun deleteTeacherByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(collegeService.deleteByIds(ids))
    }
}