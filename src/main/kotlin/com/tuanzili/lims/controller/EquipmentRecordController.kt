package com.tuanzili.lims.controller

import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.controller.param.UpdateParam
import com.tuanzili.lims.entity.EquipmentRecord
import com.tuanzili.lims.service.EquipmentRecordService
import com.tuanzili.lims.service.EquipmentService
import com.tuanzili.lims.vo.EquipmentRecordVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("/equipmentRecord", tags = ["设备记录"])
@RestController()
@RequestMapping("/equipmentRecord")
class EquipmentRecordController(
    private val equipmentRecordService: EquipmentRecordService
) {

    @ApiOperation("设备列表")
    @PostMapping("/list")
    fun equipmentList(@RequestBody seeker: Seeker<EquipmentRecord>): Result<Pagination<EquipmentRecord>> {
        return Result.ok(equipmentRecordService.pagination(seeker))
    }
    @ApiOperation("设备列表")
    @PostMapping("/selectList")
    fun selectEquipmentList(@RequestBody seeker: Seeker<EquipmentRecord>): Result<Pagination<EquipmentRecordVo>> {
        return Result.ok(equipmentRecordService.selectEquipmentList(seeker))
    }
    @ApiOperation("添加设备")
    @PostMapping("/insert")
    fun insertEquipment(@RequestBody equipmentRecord: EquipmentRecord): Result<Boolean> {
        if (equipmentRecord.effective){
            return  Result.error("参数为空")
        }
        return  Result.ok(equipmentRecordService.insertEquipmentRecord(equipmentRecord))
    }
   

    @ApiOperation("根据设备Ids批量删除")
    @PostMapping("/delete")
    fun deleteEquipmentByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(equipmentRecordService.deleteByIds(ids))
    }

}