package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.app.home.pojo.BidOnLookPOJO;

import java.util.List;

public class BidOnLookResult {
    List<BidOnLookPOJO> onLookList;

    public List<BidOnLookPOJO> getOnLookList() {
        return onLookList;
    }

    public void setOnLookList(List<BidOnLookPOJO> onLookList) {
        this.onLookList = onLookList;
    }

    @Override
    public String toString() {
        return "BidOnLookResult{" +
                "onLookList=" + onLookList +
                '}';
    }
}
