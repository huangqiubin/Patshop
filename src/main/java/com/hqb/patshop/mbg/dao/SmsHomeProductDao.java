package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.SmsHomeProduct;

public interface SmsHomeProductDao {
    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeProduct record);

    int insertSelective(SmsHomeProduct record);

    SmsHomeProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsHomeProduct record);

    int updateByPrimaryKey(SmsHomeProduct record);
}