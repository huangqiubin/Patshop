package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.PmsBidResultModel;

public interface PmsBidResultDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsBidResultModel record);

    int insertSelective(PmsBidResultModel record);

    PmsBidResultModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsBidResultModel record);

    int updateByPrimaryKey(PmsBidResultModel record);
}