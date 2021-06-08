package com.tuanzili.lims.vo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
@ApiModel("拼多多频道链接")
class PddChannelLinkVO(
        @ApiModelProperty("1.9包邮")
        val freeShipping: String ,
        @ApiModelProperty("今日爆款")
        val todaySExplosion: String ,
        @ApiModelProperty("品牌清仓")
        val brandClearance: String ,
        @ApiModelProperty("转盘抽免单")
        val rotaryFreeTicket: String ,
        @ApiModelProperty("百亿补贴")
        val tenBillionSubsidies: String ,
        @ApiModelProperty("限时秒杀")
        val timedSpike: String ,
        @ApiModelProperty("红包")
        val redEnvelope: String ,
        @ApiModelProperty("刮刮卡")
        val scratchCard: String
)