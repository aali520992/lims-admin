package com.tuanzili.lims

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@JsonIgnoreProperties(ignoreUnknown = false)
class LimsApplication

fun main(args: Array<String>) {
    runApplication<LimsApplication>(*args)
}
