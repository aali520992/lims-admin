package com.tuanzili.lims.config.common


import com.jxpanda.common.utils.toJson
import com.pdd.pop.sdk.http.PopHttpClient
import com.pdd.pop.sdk.http.api.pop.request.*
import com.pdd.pop.sdk.http.api.pop.response.*

import com.tuanzili.lims.controller.param.PddParam
import org.springframework.stereotype.Service


private const val PID = "9413219_197422310"
private const val PID_NAME = "实验室管理系统"

@Service
class PddService(
    private val pddClient: PopHttpClient
) {
    fun selectProductList(product: PddParam.SelectProduct): PddDdkGoodsSearchResponse.GoodsSearchResponse? {
        val request = PddDdkGoodsSearchRequest()
        request.setKeyword(product.keyword)
        request.setOptId(product.optId)
        request.setPage(product.page)
        request.setPageSize(product.pageSize)
        request.setSortType(product.sortType)
        request.setWithCoupon(product.withCoupon)
        request.setRangeList(product.rangeList)
        request.setCatId(product.catId)
        request.setGoodsSignList(product.goodsIdList)
        request.setMerchantType(product.merchantType)
        request.setPid(PID)
        request.setCustomParameters(product.customParameters)
        request.setMerchantTypeList(product.merchantTypeList)
        request.setIsBrandGoods(product.isBrandGoods)
        return pddClient.syncInvoke(request).goodsSearchResponse
    }
    fun createPid(number:Long): MutableList<PddDdkGoodsPidGenerateResponse.PIdGenerateResponsePIdListItem>? {


        val request = PddDdkGoodsPidGenerateRequest()
        request.setNumber(number)


        return  pddClient.syncInvoke(request).pIdGenerateResponse.pIdList
    }
    fun generateProductLink(productLink: PddParam.ProductLink): PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem? {
        val request = PddDdkGoodsPromotionUrlGenerateRequest()
        request.setPId(PID)
        request.setGoodsSignList(listOf(productLink.goodId))
        request.setGenerateShortUrl(productLink.generateSchemaUrl)
        request.setMultiGroup(productLink.multiGroup)
        request.setCustomParameters(productLink.customParameters)
        request.setGenerateWeApp(productLink.generateWeappWebview)
        request.setZsDuoId(productLink.zsDuoId)
        request.setGenerateWeApp(productLink.generateWeApp)
        request.setGenerateMallCollectCoupon(productLink.generateMallCollectCoupon)
        request.setGenerateSchemaUrl(productLink.generateSchemaUrl)
        request.setGenerateQqApp(productLink.generateQqApp)
        return pddClient.syncInvoke(request).goodsPromotionUrlGenerateResponse.goodsPromotionUrlList.get(0)
    }


    fun channelList(): MutableList<PddDdkCmsPromUrlGenerateResponse.CmsPromotionUrlGenerateResponseUrlListItem>? {
        val request = PddDdkCmsPromUrlGenerateRequest()
        request.setGenerateShortUrl(true)
        request.setGenerateMobile(true)
        request.setMultiGroup(true)
        request.setCustomParameters("true")
        request.setGenerateWeApp(true)
        request.setGenerateShortUrl(true)
        request.setChannelType(0)
        request.setPIdList(listOf(PID))
        request.setGenerateSchemaUrl(true)
        // 1.9包邮
      return pddClient.syncInvoke(request).cmsPromotionUrlGenerateResponse.urlList

    }

    fun channelProduct(ChannelProduct: PddParam.ChannelProduct): MutableList<PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponseListItem> {
        val request = PddDdkGoodsRecommendGetRequest()
        request.setOffset(ChannelProduct.offset)
        request.setLimit(ChannelProduct.limit)
        request.setChannelType(ChannelProduct.channelType)
        request.setPid(PID)
        return pddClient.syncInvoke(request).goodsBasicDetailResponse.list
    }


}

