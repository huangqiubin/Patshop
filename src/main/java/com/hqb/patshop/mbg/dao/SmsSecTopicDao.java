package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.SmsSecTopic;

import java.util.List;

public interface SmsSecTopicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsSecTopic record);

    int insertSelective(SmsSecTopic record);

    SmsSecTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsSecTopic record);

    int updateByPrimaryKey(SmsSecTopic record);

    List<SmsSecTopic> selectAll();

    int selectPrimaryKeyBySecTopicName(String secTopicName);
}