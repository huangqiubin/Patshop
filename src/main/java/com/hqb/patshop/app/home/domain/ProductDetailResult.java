package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.PmsProduct1Dao;

public class ProductDetailResult {
    private PmsProduct1Dao pmsProduct1Dao;

    public PmsProduct1Dao getPmsProduct1Dao() {
        return pmsProduct1Dao;
    }

    public void setPmsProduct1Dao(PmsProduct1Dao pmsProduct1Dao) {
        this.pmsProduct1Dao = pmsProduct1Dao;
    }

    @Override
    public String toString() {
        return "ProductDetailResult{" +
                "pmsProduct1Dao=" + pmsProduct1Dao +
                '}';
    }
}
