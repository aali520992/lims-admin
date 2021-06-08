package com.tuanzili.lims.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.entity.Profession
import com.tuanzili.lims.entity.Room
import com.tuanzili.lims.service.RoomService
import com.tuanzili.lims.vo.ProfessionVo
import com.tuanzili.lims.vo.RoomVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@Api("/room", tags = ["教室"])
@RestController()
@RequestMapping("/room")
class RoomController(
    private val roomService: RoomService
) {
    @ApiOperation("教室列表")
    @PostMapping("/roomList/{professionId:\\d+}")
    fun selectProfessionList(@PathVariable("professionId") professionId: String): Result<List<RoomVo>> {
        return Result.ok(roomService.list(QueryWrapper<Room>().`in`(Room.PROFESSION_ID,professionId)).map { RoomVo(it) })
    }
    @ApiOperation("教室列表")
    @GetMapping("/roomList")
    fun selectProfessionList(): Result<List<RoomVo>> {
        return Result.ok(roomService.list().map { RoomVo(it) })
    }
    @ApiOperation("教室列表")
    @PostMapping("/list")
    fun roomList(@RequestBody seeker: Seeker<Room>): Result<Pagination<Room>> {
        return Result.ok(roomService.pagination(seeker))
    }
    @ApiOperation("添加教室")
    @PostMapping("/insert")
    fun roomList(@RequestBody room:Room): Result<Boolean> {
        return Result.ok(roomService.save(room))
    }
    @ApiOperation("添加教室")
    @PostMapping("/update")
    fun roomUpdate(@RequestBody room:Room): Result<Boolean> {
        return Result.ok(roomService.updateById(room))
    }

    @ApiOperation("根据Ids批量删除")
    @PostMapping("/delete")
    fun deleteTeacherByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(roomService.deleteByIds(ids))
    }
}