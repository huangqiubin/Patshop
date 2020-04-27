package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.app.home.dto.TopicAndSecTopic;

import java.util.List;

public class CommunityResult {
    //社区话题列表
    private List<TopicAndSecTopic> topicList;

    public List<TopicAndSecTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TopicAndSecTopic> topicList) {
        this.topicList = topicList;
    }

    @Override
    public String toString() {
        return "CommunityResult{" +
                "topicList=" + topicList +
                '}';
    }
}
