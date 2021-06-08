package com.tuanzili.lims.config

import com.pdd.pop.sdk.http.PopHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.pdd.pop.sdk.http.PopAccessTokenClient


//your clientId
private const val CLIENT_ID = "6b91a453ae98420290ca3796cdf5b2fa"
//your clientSecret
private const val CLIENT_SECRET = "fd25e7d5426d883185019fce49d86bc170c32fd1"

@Configuration
class PddClientConfig {

    @Bean
    fun pddClient(): PopHttpClient {
        val accessTokenClient = PopAccessTokenClient(CLIENT_ID, CLIENT_ID)
        return PopHttpClient(CLIENT_ID, CLIENT_SECRET)
    }


}