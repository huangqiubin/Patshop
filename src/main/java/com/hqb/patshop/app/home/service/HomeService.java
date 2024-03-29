package com.hqb.patshop.app.home.service;


import com.hqb.patshop.app.home.domain.HomeBidProductResult;
import com.hqb.patshop.app.home.domain.HomeContentResult;
import com.hqb.patshop.app.home.domain.HomeHotBidResult;
import com.hqb.patshop.app.home.domain.ProductDetailResult;

/**
 * 首页内容管理Service
 */
public interface HomeService {

    /**
     * 获取首页内容
     * @return
     */
    HomeContentResult content();

    /**
     * 获取首页分类拍品
     * @return
     */
    HomeBidProductResult homeBidProduct(String categoryName);

    /**
     * 获取首页热门拍卖
     */
    HomeHotBidResult homeHotProduct();

    /**
     * 获取商品详情
     */
    ProductDetailResult productDetail(long productId);

    /**
     * 出价竞拍
     */
    Integer bidProduct(long productId, Double bidPatCoin, String userName);

    /**
     * 添加用户围观商品
     */
    Integer onLookProduct(int productId, int userId);

    /**
     * 添加用户参拍表
     */
    Integer onBidProduct(long productId, long userId);
}
