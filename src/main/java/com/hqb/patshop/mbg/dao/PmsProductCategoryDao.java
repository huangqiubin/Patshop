package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.PmsProductCategory;

public interface PmsProductCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCategory record);

    int insertSelective(PmsProductCategory record);

    PmsProductCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductCategory record);

    int updateByPrimaryKey(PmsProductCategory record);

    PmsProductCategory selectByCategoryName(String categoryName);
}