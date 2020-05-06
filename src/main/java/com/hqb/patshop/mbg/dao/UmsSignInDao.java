package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.UmsSignInModel;

public interface UmsSignInDao {
    int deleteByPrimaryKey(Long id);

    int insert(UmsSignInModel record);

    int insertSelective(UmsSignInModel record);

    UmsSignInModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsSignInModel record);

    int updateByPrimaryKey(UmsSignInModel record);

    UmsSignInModel selectLastByUserName(String userName);

}