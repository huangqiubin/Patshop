package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.SmsHomeProductDao;

import java.util.List;

public class ManageSaleContentResult {

    private List<SmsHomeProductDao> onProductList;

    private List<SmsHomeProductDao> endProductList;

    public List<SmsHomeProductDao> getOnProductList() {
        return onProductList;
    }

    public void setOnProductList(List<SmsHomeProductDao> onProductList) {
        this.onProductList = onProductList;
    }

    public List<SmsHomeProductDao> getEndProductList() {
        return endProductList;
    }

    public void setEndProductList(List<SmsHomeProductDao> endProductList) {
        this.endProductList = endProductList;
    }

    @Override
    public String toString() {
        return "ManageSaleContentResult{" +
                "onProductList=" + onProductList +
                ", endProductList=" + endProductList +
                '}';
    }
}
