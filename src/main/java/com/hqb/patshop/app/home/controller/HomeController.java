package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.*;
import com.hqb.patshop.app.home.service.HomeService;
import com.hqb.patshop.common.api.CommonResult;
import com.hqb.patshop.mbg.dao.PmsBidResultDao;
import com.hqb.patshop.mbg.dao.PmsOnLookDao;
import com.hqb.patshop.mbg.dao.UmsMemberDao;
import com.hqb.patshop.mbg.model.PmsBidResultModel;
import com.hqb.patshop.mbg.model.PmsOnLookModel;
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
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<HomeContentResult> content() {
        HomeContentResult homeContentResult = homeService.content();
        return CommonResult.success(homeContentResult);
    }

    /**
     * 获取首页分类拍品
     */
    @RequestMapping(value = "/bid_product", method = RequestMethod.GET)
    public CommonResult<HomeBidProductResult> homeBidProduct(String categoryName) {
        HomeBidProductResult homeBidProductResult = homeService.homeBidProduct(categoryName);
        return CommonResult.success(homeBidProductResult);
    }

    /**
     * 获取首页热门拍卖
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
     */
    @RequestMapping(value = "/bid_product_l", method = RequestMethod.GET)
    public CommonResult<Integer> bidProduct(long productId, Double bidPatCoin, String userName, long userId) {
        int result = homeService.bidProduct(productId, bidPatCoin, userName);
        String message;
        if (result == 0) {
            //更新参拍表
            homeService.onBidProduct(productId, userId);
            message = "竞拍成功";
        } else {
            message = "竞拍失败";
        }
        return CommonResult.success(result, message);
    }

    /**
     * 用户围观商品
     */
    @RequestMapping(value = "/onLook", method = RequestMethod.GET)
    public CommonResult<Integer> onLookProduct(int productId, int userId) {
        return CommonResult.success(homeService.onLookProduct(productId, userId));
    }

}
