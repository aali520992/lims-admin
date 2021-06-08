package com.tuanzili.lims.enumeration

/*
实验室的状态
*/
enum class Status(val code: Int, val description: Boolean) {
    OPEN(0, true),
    DISABLE(1, false),
}