package com.hqb.patshop.app.home.domain;


import com.hqb.patshop.mbg.model.PmsBidResultModel;

import java.util.List;

public class BidSaleResult {

    private List<PmsBidResultModel> bidResultModelList;

    public List<PmsBidResultModel> getBidResultModelList() {
        return bidResultModelList;
    }

    public void setBidResultModelList(List<PmsBidResultModel> bidResultModelList) {
        this.bidResultModelList = bidResultModelList;
    }

    @Override
    public String toString() {
        return "BidSaleResult{" +
                "bidResultModelList=" + bidResultModelList +
                '}';
    }
}
