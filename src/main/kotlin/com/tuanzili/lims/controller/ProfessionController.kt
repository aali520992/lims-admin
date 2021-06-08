package com.tuanzili.lims.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.entity.Profession
import com.tuanzili.lims.service.ProfessionService
import com.tuanzili.lims.vo.ProfessionVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@Api("/profession", tags = ["专业"])
@RestController()
@RequestMapping("/profession")
class ProfessionController(
    private val professionService: ProfessionService
) {
    @ApiOperation("专业列表")
    @PostMapping("/professionList/{collegeId:\\d+}")
    fun selectProfessionList(@PathVariable("collegeId") collegeId: String): Result<List<ProfessionVo>> {
        return Result.ok(professionService.list(QueryWrapper<Profession>().`in`(Profession.COLLEGE_ID,collegeId)).map { ProfessionVo(it) })
    }
    @ApiOperation("专业列表")
    @PostMapping("/professionList")
    fun list(): Result<List<ProfessionVo>> {
        return Result.ok(professionService.list().map { ProfessionVo(it) })
    }
    @ApiOperation("专业列表")
    @PostMapping("/list")
    fun professionList(@RequestBody seeker: Seeker<Profession>): Result<Pagination<Profession>> {
        return Result.ok(professionService.pagination(seeker))
    }
    @ApiOperation("添加专业")
    @PostMapping("/insert")
    fun professionList(@RequestBody profession:Profession): Result<Boolean> {
        return Result.ok(professionService.save(profession))
    }
    @ApiOperation("添加专业")
    @PostMapping("/update")
    fun professionUpdate(@RequestBody profession:Profession): Result<Boolean> {
        return Result.ok(professionService.updateById(profession))
    }

    @ApiOperation("根据Ids批量删除")
    @PostMapping("/delete")
    fun deleteTeacherByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(professionService.deleteByIds(ids))
    }
}