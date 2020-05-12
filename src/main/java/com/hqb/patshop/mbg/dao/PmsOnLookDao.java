package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.BidResultModel;
import com.hqb.patshop.mbg.model.PmsOnLookModel;

import java.util.List;

public interface PmsOnLookDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsOnLookModel record);

    int insertSelective(PmsOnLookModel record);

    PmsOnLookModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsOnLookModel record);

    int updateByPrimaryKey(PmsOnLookModel record);

    List<BidResultModel> selectAllResultByUserId(Long userId);

    int selectCountByUserId(Long id);
}