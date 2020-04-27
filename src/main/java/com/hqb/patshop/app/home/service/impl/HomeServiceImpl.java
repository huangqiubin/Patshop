package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.domain.HomeBidProductResult;
import com.hqb.patshop.app.home.domain.HomeContentResult;
import com.hqb.patshop.app.home.domain.HomeHotBidResult;
import com.hqb.patshop.app.home.domain.ProductDetailResult;
import com.hqb.patshop.app.home.service.HomeService;
import com.hqb.patshop.mbg.dao.SmsHomeAdvertiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    SmsHomeAdvertiseMapper homeAdvertiseMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult homeContentResult = new HomeContentResult();
        // 首页广告轮播
        homeContentResult.setHomeAdvertiseList(homeAdvertiseMapper.selectHomeAdvertise());
        // 首页分类类目
        homeContentResult.setProductCategoryDaoList(homeAdvertiseMapper.selectAllProductCategory());

        return homeContentResult;
    }

    @Override
    public HomeBidProductResult homeBidProduct(String categoryName) {
        HomeBidProductResult homeBidProductResult = new HomeBidProductResult();
        homeBidProductResult.setHomeProductDaoList(homeAdvertiseMapper.selectBidProduct(categoryName));
        return homeBidProductResult;
    }

    @Override
    public HomeHotBidResult homeHotProduct() {
        HomeHotBidResult homeHotBidResult = new HomeHotBidResult();
        homeHotBidResult.setHomeProductDaoList(homeAdvertiseMapper.selectAllHomeHot());
        return homeHotBidResult;
    }

    @Override
    public ProductDetailResult productDetail(int productId) {
        ProductDetailResult productDetailResult = new ProductDetailResult();
        productDetailResult.setPmsProduct1Dao(homeAdvertiseMapper.selectProductDetail(productId));
        return productDetailResult;
    }


}
