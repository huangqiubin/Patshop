package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.PmsProductModel;

public class ProductDetailResult {
    private PmsProductModel pmsProductModel;

    public PmsProductModel getPmsProductModel() {
        return pmsProductModel;
    }

    public void setPmsProductModel(PmsProductModel pmsProductModel) {
        this.pmsProductModel = pmsProductModel;
    }

    @Override
    public String toString() {
        return "ProductDetailResult{" +
                "pmsProductModel=" + pmsProductModel +
                '}';
    }
}
