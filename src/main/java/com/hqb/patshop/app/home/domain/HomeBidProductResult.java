package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.SmsHomeProductDao;

import java.util.List;

public class HomeBidProductResult {
    // 首页分类拍卖
    private List<SmsHomeProductDao> homeProductDaoList;

    public List<SmsHomeProductDao> getHomeProductDaoList() {
        return homeProductDaoList;
    }

    public void setHomeProductDaoList(List<SmsHomeProductDao> homeProductDaoList) {
        this.homeProductDaoList = homeProductDaoList;
    }

    @Override
    public String toString() {
        return "HomeBidProductResult{" +
                "homeProductDaoList=" + homeProductDaoList +
                '}';
    }
}
