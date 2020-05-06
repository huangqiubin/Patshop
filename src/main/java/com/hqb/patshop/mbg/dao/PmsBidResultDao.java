package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.PmsBidResultModel;

import java.util.List;

public interface PmsBidResultDao {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBidResultModel record);

    int insertSelective(PmsBidResultModel record);

    PmsBidResultModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBidResultModel record);

    int updateByPrimaryKey(PmsBidResultModel record);

    int selectCountByUserId(Long userId);

    List<PmsBidResultModel> selectAllByUserId(Long userId);

}