package com.tuanzili.lims.enumeration

/**
 * 枚举的映射类，简易管理枚举的值和枚举对象的映射关系
 * */

class EnumMap {

    companion object {

        val STATUS: Map<Int, Status> = mapOf(
            Status.OPEN.code to Status.OPEN,
            Status.DISABLE.code to Status.DISABLE
        )

    }
}