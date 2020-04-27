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
    ProductDetailResult productDetail(int productId);
}
