package com.hqb.patshop.app.home.domain;


import com.hqb.patshop.mbg.model.PmsProductCategoryDao;
import com.hqb.patshop.mbg.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页内容返回封装信息
 */
public class HomeContentResult {
    // 轮播广告
    private List<SmsHomeAdvertise> homeAdvertiseList;

    // 首页类目
    private List<PmsProductCategoryDao> productCategoryDaoList;

    public List<SmsHomeAdvertise> getHomeAdvertiseList() {
        return homeAdvertiseList;
    }

    public void setHomeAdvertiseList(List<SmsHomeAdvertise> homeAdvertiseList) {
        this.homeAdvertiseList = homeAdvertiseList;
    }

    public List<PmsProductCategoryDao> getProductCategoryDaoList() {
        return productCategoryDaoList;
    }

    public void setProductCategoryDaoList(List<PmsProductCategoryDao> productCategoryDaoList) {
        this.productCategoryDaoList = productCategoryDaoList;
    }

    @Override
    public String toString() {
        return "HomeContentResult{" +
                "homeAdvertiseList=" + homeAdvertiseList +
                ", productCategoryDaoList=" + productCategoryDaoList +
                '}';
    }
}
