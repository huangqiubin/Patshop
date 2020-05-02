package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.*;

import java.util.List;
public interface SmsHomeAdvertiseMapper {

    List<SmsHomeAdvertise> selectHomeAdvertise();

    List<PmsProductCategoryDao> selectAllProductCategory();

    List<SmsHomeProductDao> selectBidProduct(String categoryName);

    List<SmsHomeHot> selectAllHomeHot();

}
