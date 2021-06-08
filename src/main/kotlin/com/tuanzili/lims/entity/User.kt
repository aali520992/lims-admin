package com.tuanzili.lims.entity

import com.jxpanda.common.base.Entity
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import com.jxpanda.common.utils.formatting

/**
 * 
 *
 * @author tuanzili
 * @since 2021-04-26
 */
@TableName("`user`")
@ApiModel(value="User对象", description="")
data class User(
        @ApiModelProperty(value = "创建这条记录的用户ID")
        var creatorId: Long = 0,
        @ApiModelProperty(value = "更新这条记录的用户ID")
        var updaterId: Long = 0,
        @ApiModelProperty(value = "工号（学号）")
        var username: String = "",
        @ApiModelProperty(value = "登录密码")
        var password: String = "",
        @ApiModelProperty(value = "账户启用状态（0：未知，1：启用，2：禁用）")
        var status: Int = 0,
        @ApiModelProperty(value = "角色（0超级管理员，1：实验室管理员，2教师，3：学生）")
        var role: String = "",
        @ApiModelProperty(value = "头像")
        var avatar: String = "",
        @ApiModelProperty(value = "昵称")
        var nickname: String = "",
        @ApiModelProperty(value = "联系方式")
        var phone: String = "",
        @ApiModelProperty(value = "邮箱")
        var email: String = "",
        @ApiModelProperty(value = "生日")
        var birthday: String = "1970-01-01 00:00:00",
        @ApiModelProperty(value = "姓名")
        var compellation: String = "",
        @ApiModelProperty(value = "身份证号码")
        var idNum: String = "",
        @ApiModelProperty(value = "名族")
        var ethnic: String = "",
        @ApiModelProperty(value = "职称")
        var jobTitle: String = "",
        @ApiModelProperty(value = "学历")
        var education: String = "",
        @ApiModelProperty(value = "课时费")
        var classFee: String = "",
        @ApiModelProperty(value = "所教科目")
        var literaryCourse: String = "",
        @ApiModelProperty(value = "籍贯")
        var nativePlace: String = "",
        @ApiModelProperty(value = "政治面貌")
        var politicsStatus: String = "0",
        @ApiModelProperty(value = "详细居住地址")
        var address: String = "",
        @ApiModelProperty(value = "联系人")
        var linkman: String = "",
        @ApiModelProperty(value = "联系人电话")
        var linkmanPhone: String = "",
        @ApiModelProperty(value = "学院Id")
        var collegeId: Long = 0,
        @ApiModelProperty(value = "学院名称")
        var collegeName: String = "",
        @ApiModelProperty(value = "班级Id")
        var roomId: Long = 0,
        @ApiModelProperty(value = "班级名称")
        var roomName: String = "",
        @ApiModelProperty(value = "备注")
        var remark: String = ""
) : Entity() {

    data class Updater(
                var creatorId: Long? = null,
                var updaterId: Long? = null,
                var username: String? = null,
                var password: String? = null,
                var status: Int? = null,
                var role: String? = null,
                var avatar: String? = null,
                var nickname: String? = null,
                var phone: String? = null,
                var email: String? = null,
                var birthday: String? = null,
                var compellation: String? = null,
                var idNum: String? = null,
                var ethnic: String? = null,
                var jobTitle: String? = null,
                var education: String? = null,
                var classFee: String? = null,
                var literaryCourse: String? = null,
                var nativePlace: String? = null,
                var politicsStatus: String? = null,
                var address: String? = null,
                var linkman: String? = null,
                var linkmanPhone: String? = null,
                var collegeId: Long? = null,
                var collegeName: String? = null,
                var roomId: Long? = null,
                var roomName: String? = null,
                var remark: String? = null
    ) : Entity.Updater<User>(){
        override val entityClass: Class<User> = User::class.java
    }

    companion object {
        const val CREATOR_ID : String = "creator_id"
        const val UPDATER_ID : String = "updater_id"
        const val USERNAME : String = "username"
        const val PASSWORD : String = "password"
        const val STATUS : String = "status"
        const val ROLE : String = "role"
        const val AVATAR : String = "avatar"
        const val NICKNAME : String = "nickname"
        const val PHONE : String = "phone"
        const val EMAIL : String = "email"
        const val BIRTHDAY : String = "birthday"
        const val COMPELLATION : String = "compellation"
        const val ID_NUM : String = "id_num"
        const val ETHNIC : String = "ethnic"
        const val JOB_TITLE : String = "job_title"
        const val EDUCATION : String = "education"
        const val CLASS_FEE : String = "class_fee"
        const val LITERARY_COURSE : String = "literary_course"
        const val NATIVE_PLACE : String = "native_place"
        const val POLITICS_STATUS : String = "politics_status"
        const val ADDRESS : String = "address"
        const val LINKMAN : String = "linkman"
        const val LINKMAN_PHONE : String = "linkman_phone"
        const val COLLEGE_ID : String = "college_id"
        const val COLLEGE_NAME : String = "college_name"
        const val ROOM_ID : String = "room_id"
        const val ROOM_NAME : String = "room_name"
        const val REMARK : String = "remark"
    }

    override fun toString(): String {
        return """
            `{
                `"id":"$id",
                `"createdDate":"${createdDate.formatting()}",
                `"updatedDate":"${updatedDate.formatting()}",
                `"deletedDate":"${deletedDate.formatting()}",
                `"deleted":$deleted,
                `"creatorId":$creatorId,
                `"updaterId":$updaterId,
                `"username":"$username",
                `"password":"$password",
                `"status":$status,
                `"role":"$role",
                `"avatar":"$avatar",
                `"nickname":"$nickname",
                `"phone":"$phone",
                `"email":"$email",
                `"birthday":"$birthday",
                `"compellation":"$compellation",
                `"idNum":"$idNum",
                `"ethnic":"$ethnic",
                `"jobTitle":"$jobTitle",
                `"education":"$education",
                `"classFee":"$classFee",
                `"literaryCourse":"$literaryCourse",
                `"nativePlace":"$nativePlace",
                `"politicsStatus":"$politicsStatus",
                `"address":"$address",
                `"linkman":"$linkman",
                `"linkmanPhone":"$linkmanPhone",
                `"collegeId":$collegeId,
                `"collegeName":"$collegeName",
                `"roomId":$roomId,
                `"roomName":"$roomName",
                `"remark":"$remark"
            `}
        """.trimMargin("`").replace("\n","")
    }
}
