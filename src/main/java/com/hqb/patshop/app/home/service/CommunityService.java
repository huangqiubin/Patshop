package com.hqb.patshop.app.home.service;

import com.hqb.patshop.app.home.domain.CommunityResult;
import com.hqb.patshop.app.home.domain.HotTopicResult;
import com.hqb.patshop.app.home.dto.TopicPostDTO;
import com.hqb.patshop.common.api.CommonResult;

public interface CommunityService {

    /**
     * 获取社区热门话题
     * @return
     */
    CommunityResult hotTopicList(int hotTopic);

    /**
     * 获取社区分类话题
     */
    CommunityResult categoryTopicList(String categoryTopic);

    /**
     * 根据二级话题获取社区话题列表
     */
    CommunityResult secCategoryTopicList(String secCategoryTopic);

    /**
     * 获取社区热门话题列表
     */
    HotTopicResult hotTopicList();

    Integer postTopic(TopicPostDTO topic);
}
