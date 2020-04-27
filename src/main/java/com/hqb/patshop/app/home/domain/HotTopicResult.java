package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.SmsSecTopic;

import java.util.List;

public class HotTopicResult {

    private List<SmsSecTopic> hotTopicList;

    public List<SmsSecTopic> getHotTopicList() {
        return hotTopicList;
    }

    public void setHotTopicList(List<SmsSecTopic> hotTopicList) {
        this.hotTopicList = hotTopicList;
    }

    @Override
    public String toString() {
        return "HotTopicResult{" +
                "hotTopicList=" + hotTopicList +
                '}';
    }
}
