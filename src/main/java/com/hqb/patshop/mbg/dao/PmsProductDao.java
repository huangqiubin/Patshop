package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.PmsProductModel;

import java.util.List;

public interface PmsProductDao {

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductModel record);

    int insertSelective(PmsProductModel record);

    PmsProductModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductModel record);

    int updateByPrimaryKey(PmsProductModel record);

    PmsProductModel selectByPrimaryKeyForUpdate(Long id);

    List<PmsProductModel> selectAllDesc();

    List<PmsProductModel> selectAllByCategoryNameDesc(String categoryName);

}