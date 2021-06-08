package com.tuanzili.lims.controller.param

import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

class PddParam {

    @ApiModel("商品查询", description = "多多进宝商品查询条件都是非必填")
    data class SelectProduct(
            @ApiModelProperty("商品关键词，与opt_id字段选填一个或全部填写")
            val keyword: String? = "",
            @ApiModelProperty("商品标签类目ID，使用pdd.goods.opt.get获取")
            val optId: Long? = null,
            @ApiModelProperty("默认值1，商品分页数")
            val page: Int? = 1,
            @ApiModelProperty("默认100，每页商品数量")
            val pageSize: Int? = 40,
            @ApiModelProperty("排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;13-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序 ")
            val sortType: Int? = null,
            @ApiModelProperty("是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品")
            val withCoupon: Boolean? = null,
            @ApiModelProperty("筛选范围列表 样例：[{\"range_id\":0,\"range_from\":1,\"range_to\":1500},{\"range_id\":1,\"range_from\":1,\"range_to\":1500}] range_id枚举及描述： 0，最小成团价 1，券后价 2，佣金比例 3，优惠券价格 4，广告创建时间 5，销量 6，佣金金额 7，店铺描述分 8，店铺物流分 9，店铺服务分 10， 店铺描述分击败同行业百分比 11， 店铺物流分击败同行业百分比 12，店铺服务分击败同行业百分比 13，商品分 17 ，优惠券/最小团购价 18，过去两小时pv 19，过去两小时销量")
            val rangeList: List<PddDdkGoodsSearchRequest.RangeListItem>? = null,
            @ApiModelProperty("商品类目ID，使用pdd.goods.cats.get接口获取")
            val catId: Long? = null,
            @ApiModelProperty("商品ID列表。例如：[123456,123]，当入参带有goods_id_list字段，将不会以opt_id、 cat_id、keyword维度筛选商品")
            val goodsIdList: List<String> = emptyList(),
            @ApiModelProperty("店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）")
            val merchantType: Int? = null,
            @ApiModelProperty("推广位id")
            val pId: String? = null,
            @ApiModelProperty("自定义参数")
            val customParameters: String? = null,
            @ApiModelProperty("店铺类型数组")
            val merchantTypeList: List<Int> = emptyList(),
            @ApiModelProperty("是否为品牌商品")
            val isBrandGoods: Boolean? = null
//            @ApiModelProperty("商品标记数组，1-表示双十一商品")
//            val activityTags: List<Int> = emptyList()

    )

    data class Range(
            val range_id: Int,
            val range_from: Int,
            val range_to: Int
    )

    @ApiModel("商品推广链接", description = "生成普通商品推广链接（pId、goodsIdList）必填")
    data class ProductLink(
            @ApiModelProperty("商品ID，仅支持单个查询")
            val goodId: String,
            @ApiModelProperty("是否生成短链接，true-是，false-否")
            val generateShortUrl: Boolean = true,
            @ApiModelProperty("true--生成多人团推广链接 false--生成单人团推广链接（默认false）1、单人团推广链接：用户访问单人团推广链接，可直接购买商品无需拼团。2、多人团推广链接：用户访问双人团推广链接开团，若用户分享给他人参团，则开团者和参团者的佣金均结算给推手")
            val multiGroup: Boolean? = null,
            @ApiModelProperty("自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节")
            val customParameters: String? = null,
            @ApiModelProperty("是否生成唤起微信客户端链接，true-是，false-否，默认false")
            val generateWeappWebview: Boolean? = false,
            @ApiModelProperty("招商多多客ID")
            val zsDuoId: Long? = null,
            @ApiModelProperty("是否生成小程序推广")
            val generateWeApp: Boolean? = null,
            @ApiModelProperty("是否生成微博推广链接")
            val generateWeiboappWebview: Boolean? = null,
            @ApiModelProperty("是否生成店铺收藏券推广链接")
            val generateMallCollectCoupon: Boolean? = null,
            @ApiModelProperty("是否返回 schema URL")
            val generateSchemaUrl: Boolean = true,
            @ApiModelProperty("是否生成qq小程序")
            val generateQqApp: Boolean? = null

    )

    @ApiModel("运营频道商品查询", description = "运营频道商品查询")
    data class ChannelProduct(
            @ApiModelProperty("从多少位置开始请求；默认值 ： 0，offset需是limit的整数倍，仅支持整页翻页")
            val offset: Int? = null,
            @ApiModelProperty("请求数量；默认值 ： 400")
            val limit: Int? = null,
            @ApiModelProperty("频道类型；0, \"1.9包邮\", 1, \"今日爆款\", 2, \"品牌清仓\", 非必填 ,默认是1")
            val channelType: Int
    )


}