package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.SmsTopic;
import com.hqb.patshop.app.home.dto.TopicAndSecTopic;

import java.util.List;

public interface SmsTopicDao {

    int deleteByPrimaryKey(Integer id);

    int insert(SmsTopic record);

    int insertSelective(SmsTopic record);

    SmsTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsTopic record);

    int updateByPrimaryKey(SmsTopic record);

    List<SmsTopic> selectAllBySecTopicId(int secTopicId);

    List<TopicAndSecTopic> selectAllByHotTopic(Integer hotTopic);
}