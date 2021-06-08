package com.tuanzili.lims.config.security

import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper



class JwtRequestWrapper(
        request: HttpServletRequest,
        private val params: MutableMap<String, Array<String>>
) : HttpServletRequestWrapper(request) {

    init {
        rebuildParameterMap(request)
    }

    override fun getParameter(name: String): String {
        val value = params[name]
        return when {
            value == null -> ""
            value.isArrayOf<String>() && value.isNotEmpty() -> value[0]
            else -> value.toString()
        }
    }

    override fun getParameterMap(): Map<String, Array<String>> {
        return params
    }

    override fun getParameterNames(): Enumeration<String> {
        return Vector(params.keys).elements()
    }

    override fun getParameterValues(name: String): Array<String> {
        val value = params[name]
        return when {
            value == null -> emptyArray()
            value.isArrayOf<String>() -> value
            else -> arrayOf(value.toString())
        }
    }

    private fun rebuildParameterMap(request: HttpServletRequest) {
        val queryString = request.queryString
        if (!queryString.isNullOrEmpty()) {
            queryString.split("&".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .filter { it.contains("=") }
                    .forEach {
                        val (key, value) = it.split("=")
                        this.params.putIfAbsent(key, arrayOf(value))
                    }
        }
    }

}

