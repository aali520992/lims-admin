package com.tuanzili.lims.enumeration
/*
实验室的状态
*/
enum class Type(val code: Int, val description: String) {
    OPEN(0, "开放"),
    DISABLE(1, "禁用"),
    EMPLOY(2, "使用")
}