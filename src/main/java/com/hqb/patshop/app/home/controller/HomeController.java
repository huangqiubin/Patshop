package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.*;
import com.hqb.patshop.app.home.service.HomeService;
import com.hqb.patshop.common.api.CommonResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService;

    /**
     * 获取首页内容
     *
     * @return
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<HomeContentResult> content() {
        HomeContentResult homeContentResult = homeService.content();
        return CommonResult.success(homeContentResult);
    }

    /**
     * 获取首页分类拍品
     *
     * @return
     */
    @RequestMapping(value = "/bid_product", method = RequestMethod.GET)
    public CommonResult<HomeBidProductResult> homeBidProduct(String categoryName) {
        HomeBidProductResult homeBidProductResult = homeService.homeBidProduct(categoryName);
        return CommonResult.success(homeBidProductResult);
    }

    /**
     * 获取首页热门拍卖
     *
     * @return
     */
    @RequestMapping(value = "/home_hot_bid", method = RequestMethod.GET)
    public CommonResult<HomeHotBidResult> homeHotBid() {
        HomeHotBidResult homeHotBidResult = homeService.homeHotProduct();
        return CommonResult.success(homeHotBidResult);
    }

    /**
     * 获取商品详情
     */
    @RequestMapping(value = "/product_detail", method = RequestMethod.GET)
    public CommonResult<ProductDetailResult> productDetail(long productId) {
        ProductDetailResult productDetailResult = homeService.productDetail(productId);
        return CommonResult.success(productDetailResult);
    }

    /**
     * 商品竞拍接口
     *
     * @param productId  商品id
     * @param bidPatCoin 竞拍价格
     * @param userName   用户名
     * @return
     */
    @RequestMapping(value = "/bid_product_l", method = RequestMethod. GET)
    public CommonResult<Integer> bidProduct(long productId, Double bidPatCoin, String userName) {
        int result = homeService.bidProduct(productId, bidPatCoin, userName);
        String message = new String();
        if (result == 0) {
            message = "竞拍成功";
        } else {
            message = "竞拍失败";
        }
        return CommonResult.success(result, message);
    }


}
