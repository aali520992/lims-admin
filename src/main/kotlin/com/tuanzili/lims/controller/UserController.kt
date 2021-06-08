package com.tuanzili.lims.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.jxpanda.common.base.Pagination
import com.jxpanda.common.base.Result
import com.jxpanda.common.base.Seeker
import com.tuanzili.lims.config.common.AuthService
import com.tuanzili.lims.config.security.JwtUser
import com.tuanzili.lims.controller.param.CommonParam
import com.tuanzili.lims.controller.param.UpdateParam
import com.tuanzili.lims.entity.User
import com.tuanzili.lims.service.UserService
import com.tuanzili.lims.vo.UserVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*


@Api("/user", tags = ["用户"])
@RestController()
@RequestMapping("/user")
class UserController (
    private val userService: UserService
){

    @ApiOperation("用户列表")
    @RequestMapping("/list")
    fun userList(@RequestBody seeker: Seeker<User>): Result<Pagination<User>> {
        return Result.ok(userService.pagination(seeker))
    }
    @ApiOperation("管理员列表")
    @RequestMapping("/adminList/{collegeId:\\d+}")
    fun selectAdminsById(@PathVariable("collegeId") collegeId: String): Result<List<UserVo.TeacherVo>> {
        return Result.ok(userService.list(QueryWrapper<User>().`in`(User.COLLEGE_ID,collegeId).eq(User.ROLE,1).eq(User.ROLE,1)).map { UserVo.TeacherVo(it) })
    }

    @ApiOperation("管理员列表")
    @RequestMapping("/adminList")
    fun selectAdminList(): Result<List<UserVo.TeacherVo>> {
        return Result.ok(userService.list(QueryWrapper<User>().eq(User.ROLE,1).eq(User.ROLE,1)).map { UserVo.TeacherVo(it) })
    }

    @ApiOperation("教师列表")
    @RequestMapping("/teacherList/{collegeId:\\d+}")
    fun selectTeacherListById(@PathVariable("collegeId") collegeId: String): Result<List<UserVo.TeacherVo>> {
        return Result.ok(userService.list(QueryWrapper<User>().`in`(User.COLLEGE_ID,collegeId).`in`(User.ROLE,2)).map { UserVo.TeacherVo(it) })
    }

    @ApiOperation("教师列表")
    @RequestMapping("/teacherList")
    fun selectTeacherList(): Result<List<UserVo.TeacherVo>> {
        return Result.ok(userService.list(QueryWrapper<User>().`in`(User.ROLE,2)).map { UserVo.TeacherVo(it) })
    }

    @ApiOperation("重置密码")
    @RequestMapping("/update")
    fun updateUser(@RequestBody updateParam: UpdateParam.UserParam): Result<Boolean> {
        if (updateParam.id.isNullOrBlank()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(userService.updateById(updateParam.toUpdater()))
    }
    @ApiOperation("根据用户Ids批量删除")
    @RequestMapping("/delete")
    fun deleteUserByIds(@RequestBody deleteParam: CommonParam.Delete): Result<Boolean> {
        val (ids) = deleteParam
        if (ids.isNullOrEmpty()){
            return  Result.error("id不能为空")
        }
        return  Result.ok(userService.deleteByIds(ids))
    }

}
