package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.domain.CommunityResult;
import com.hqb.patshop.app.home.domain.HotTopicResult;
import com.hqb.patshop.app.home.dto.TopicPostDTO;
import com.hqb.patshop.app.home.service.CommunityService;
import com.hqb.patshop.mbg.dao.SmsSecTopicDao;
import com.hqb.patshop.mbg.dao.SmsTopicDao;
import com.hqb.patshop.mbg.dao.UmsMemberDao;
import com.hqb.patshop.mbg.model.SmsTopic;
import com.hqb.patshop.mbg.model.UmsMember;
import org.apache.shiro.SecurityUtils;
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
    UmsMemberDao memberDao;

    @Override
    public CommunityResult hotTopicList(int position) {
        CommunityResult communityResult = new CommunityResult();
        switch (position) {
            case 1:
                communityResult.setTopicList(smsTopicDao.selectAllByCategory("游戏点劵"));
                break;
            case 2:
                communityResult.setTopicList(smsTopicDao.selectAllByCategory("手机数码"));
                break;
            case 3:
                communityResult.setTopicList(smsTopicDao.selectAllByCategory("美妆好物"));
                break;
            case 4:
                communityResult.setTopicList(smsTopicDao.selectAllByCategory("生活百货"));
                break;
            default:
                communityResult.setTopicList(smsTopicDao.selectAllByHotTopic(1));
        }
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
        smsTopic.setTopicImage(topic.getTopicImage());
        //获取话题二级目录id
        int secTopicTypeId = smsSecTopicDao.selectPrimaryKeyBySecTopicName(topic.getTopicSecType());
        smsTopic.setSecTopicId(secTopicTypeId);
        //获取用户信息
        SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        UmsMember member = memberDao.selectUserByUserName(userName);
        smsTopic.setUserAvatar(member.getIcon());
        smsTopic.setUserNickname(member.getNickname());
        //是否热门话题
        smsTopic.setHotTopic(0);
        smsTopic.setTopicType(0);
        smsTopic.setCreateTime(new Date());
        smsTopic.setUserId(Integer.parseInt(member.getId() + ""));
        smsTopic.setTopicHotValue(Math.random() * 1000);
        int position = smsTopicDao.insert(smsTopic);
        if (position != 0) {
            return position;
        } else {
            return 0;
        }
    }
}
