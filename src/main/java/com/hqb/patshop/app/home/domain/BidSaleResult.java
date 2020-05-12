package com.hqb.patshop.app.home.domain;


import com.hqb.patshop.app.home.pojo.BidSalePOJO;
import com.hqb.patshop.mbg.model.BidResultModel;

import java.util.List;

public class BidSaleResult {
    List<BidSalePOJO> bidResultList;

    public List<BidSalePOJO> getBidResultList() {
        return bidResultList;
    }

    public void setBidResultList(List<BidSalePOJO> bidResultList) {
        this.bidResultList = bidResultList;
    }

    @Override
    public String toString() {
        return "BidSaleResult{" +
                "bidResultList=" + bidResultList +
                '}';
    }
}
