package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.SmsHomeHot;

import java.util.List;

public class HomeHotBidResult {
    private List<SmsHomeHot> homeProductDaoList;

    public List<SmsHomeHot> getHomeProductDaoList() {
        return homeProductDaoList;
    }

    public void setHomeProductDaoList(List<SmsHomeHot> homeProductDaoList) {
        this.homeProductDaoList = homeProductDaoList;
    }

    @Override
    public String toString() {
        return "HomeHotBidResult{" +
                "homeProductDaoList=" + homeProductDaoList +
                '}';
    }
}
