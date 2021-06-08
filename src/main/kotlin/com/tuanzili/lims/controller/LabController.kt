package com.tuanzili.lims.controller

import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.controller.param.UpdateParam
import com.tuanzili.lims.entity.Lab
import com.tuanzili.lims.service.LabService
import com.tuanzili.lims.vo.LabVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@Api("/lab", tags = ["实验室"])
@RestController()
@RequestMapping("/lab")
class LabController(
    private val labService: LabService
) {
    @ApiOperation("实验室列表")
    @PostMapping("/list")
    fun selectLabList(@RequestBody seeker: Seeker<Lab>): Result<Pagination<Lab>> {
        return Result.ok(labService.pagination(seeker))
    }
    @ApiOperation("实验室列表")
    @GetMapping("/labList")
    fun labList(): Result<List<LabVo>> {
        return Result.ok(labService.list().map { LabVo(it) })
    }
    @ApiOperation("添加实验室")
    @PostMapping("/insert")
    fun insertLab(@RequestBody lab: Lab): Result<Boolean> {
        if (lab.effective){
            return  Result.error("参数为空")
        }
        return  Result.ok(labService.insertLabByAdmin(lab))
    }
    @ApiOperation("修改实验室")
    @PostMapping("/update")
    fun updateLab(@RequestBody updateParam: UpdateParam.LabParam): Result<Boolean> {
        if (updateParam.id.isNullOrBlank()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(labService.updateById(updateParam.toUpdater()))
    }

    @ApiOperation("根据实验室Ids批量删除")
    @PostMapping("/delete")
    fun deleteLabByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(labService.deleteByIds(ids))
    }

}