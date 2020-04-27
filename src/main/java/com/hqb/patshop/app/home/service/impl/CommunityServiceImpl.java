package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.domain.CommunityResult;
import com.hqb.patshop.app.home.domain.HotTopicResult;
import com.hqb.patshop.app.home.dto.TopicPostDTO;
import com.hqb.patshop.app.home.service.CommunityService;
import com.hqb.patshop.mbg.dao.SmsSecTopicDao;
import com.hqb.patshop.mbg.dao.SmsTopicDao;
import com.hqb.patshop.mbg.dao.UmsMemberMapper;
import com.hqb.patshop.mbg.model.SmsTopic;
import com.hqb.patshop.mbg.model.UmsMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    SmsTopicDao smsTopicDao;
    @Autowired
    SmsSecTopicDao smsSecTopicDao;
    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Override
    public CommunityResult hotTopicList(int hotTopic) {
        CommunityResult communityResult = new CommunityResult();
        communityResult.setTopicList(smsTopicDao.selectAllByHotTopic(hotTopic));
        return communityResult;
    }

    @Override
    public CommunityResult categoryTopicList(String categoryTopic) {
        return null;
    }

    @Override
    public CommunityResult secCategoryTopicList(String secCategoryTopic) {
        return null;
    }

    @Override
    public HotTopicResult hotTopicList() {
        HotTopicResult hotTopicResult = new HotTopicResult();
        hotTopicResult.setHotTopicList(smsSecTopicDao.selectAll());
        return hotTopicResult;
    }

    @Override
    public Integer postTopic(TopicPostDTO topic) {
        SmsTopic smsTopic = new SmsTopic();
        smsTopic.setTopicContent(topic.getTopicContent());
        smsTopic.setTopicTitle("");
        smsTopic.setTopicCategory(topic.getTopicType());
        //获取话题二级目录id
        int secTopicTypeId = smsSecTopicDao.selectPrimaryKeyBySecTopicName(topic.getTopicSecType());
        smsTopic.setSecTopicId(secTopicTypeId);
        //获取用户信息
        UmsMemberDao memberDao = umsMemberMapper.selectMember(12);
        smsTopic.setUserAvatar(memberDao.getIcon());
        smsTopic.setUserNickname(memberDao.getNickname());
        //是否热门话题
        smsTopic.setHotTopic(0);
        smsTopic.setTopicType(0);
        smsTopic.setCreateTime(new Date());
        smsTopic.setUserId(Integer.parseInt(memberDao.getId() + ""));
        smsTopic.setTopicHotValue(Math.random() * 1000);
        int position = smsTopicDao.insert(smsTopic);
        if (position != 0) {
            return position;
        } else {
            return 0;
        }
    }
}
