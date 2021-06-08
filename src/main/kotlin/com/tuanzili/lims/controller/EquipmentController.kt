package com.tuanzili.lims.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.controller.param.UpdateParam
import com.tuanzili.lims.entity.Equipment
import com.tuanzili.lims.entity.User
import com.tuanzili.lims.service.EquipmentService
import com.tuanzili.lims.vo.EquipmentVo
import com.tuanzili.lims.vo.UserVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@Api("/equipment", tags = ["设备"])
@RestController()
@RequestMapping("/equipment")
class EquipmentController(
    private val equipmentService: EquipmentService
) {

    @ApiOperation("设备列表")
    @PostMapping("/list")
    fun equipmentList(@RequestBody seeker: Seeker<Equipment>): Result<Pagination<Equipment>> {
        return Result.ok(equipmentService.pagination(seeker))
    }

    @ApiOperation("设备列表")
    @RequestMapping("/equipmentList/{labId:\\d+}")
    fun equipmentListByLabId(@PathVariable("labId") labId: String): Result<List<EquipmentVo>> {
        return Result.ok(equipmentService.list(QueryWrapper<Equipment>().`in`(Equipment.LAB_ID,labId)).map { EquipmentVo(it) })
    }
    @ApiOperation("添加设备")
    @PostMapping("/insert")
    fun insertEquipment(@RequestBody equipment: Equipment): Result<Boolean> {
        if (equipment.effective){
            return  Result.error("参数为空")
        }
        return  Result.ok(equipmentService.save(equipment))
    }
   

    @ApiOperation("根据设备Ids批量删除")
    @PostMapping("/delete")
    fun deleteEquipmentByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(equipmentService.deleteByIds(ids))
    }

}