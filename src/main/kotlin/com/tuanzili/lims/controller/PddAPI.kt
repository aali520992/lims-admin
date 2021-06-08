package com.tuanzili.lims.controller

import com.tuanzili.lims.config.common.PddService
import com.jxpanda.common.base.Result
import com.pdd.pop.sdk.http.api.pop.response.PddDdkCmsPromUrlGenerateResponse
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidGenerateResponse
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPromotionUrlGenerateResponse
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse
import com.tuanzili.lims.controller.param.PddParam
import com.tuanzili.lims.vo.PddChannelLinkVO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*


@Api("/pdd", tags = ["拼多多"])
@RestController
@RequestMapping("/pdd")
class PddAPI(
        private val pddService: PddService
) {
    @CrossOrigin
    @ApiOperation("多多进宝商品查询")
    @PostMapping("/product/list")
    fun selectProductList(@RequestBody product: PddParam.SelectProduct): Result<PddDdkGoodsSearchResponse.GoodsSearchResponse> {
        return Result.ok(pddService.selectProductList(product))
    }

//    @CrossOrigin
//    @ApiOperation("拼多多类目列表")
//    @GetMapping("/cats/list")
//    fun selectCatsList(): Result<List<PddGoodsCatsGetResponse.GoodsCatsGetResponseGoodsCatsListItem>> {
//        return Result.ok(pddService.selectCats())
//    }

    @CrossOrigin
    @ApiOperation("多多进宝商品推广链接生成")
    @PostMapping("/product/link")
    fun generateProductLink(@RequestBody promotionLink: PddParam.ProductLink): Result<PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem> {
        return Result.ok(pddService.generateProductLink(promotionLink))
    }
    @CrossOrigin
    @ApiOperation("多多进宝商品推广链接生成")
    @PostMapping("/pid/create")
    fun generatePid(): Result<MutableList<PddDdkGoodsPidGenerateResponse.PIdGenerateResponsePIdListItem>> {
        return Result.ok(pddService.createPid(5))
    }

    @CrossOrigin
    @ApiOperation("生成多多进宝频道推广")
    @GetMapping("/channel/list")
    fun channelList(): Result<MutableList<PddDdkCmsPromUrlGenerateResponse.CmsPromotionUrlGenerateResponseUrlListItem>> {
        return Result.ok(pddService.channelList())
    }


}