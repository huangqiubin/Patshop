package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.CommunityResult;
import com.hqb.patshop.app.home.domain.HotTopicResult;
import com.hqb.patshop.app.home.dto.TopicPostDTO;
import com.hqb.patshop.app.home.service.CommunityService;
import com.hqb.patshop.common.api.CommonResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @RequestMapping(value = "/hot_topic", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<CommunityResult> content() {
        CommunityResult communityResult = communityService.hotTopicList(1);
        return CommonResult.success(communityResult);
    }

    @RequestMapping(value = "/topic_list", method = RequestMethod.GET)
    public CommonResult<HotTopicResult> hotTopicList() {
        HotTopicResult hotTopicResult = communityService.hotTopicList();
        return CommonResult.success(hotTopicResult);
    }

    @RequestMapping(value = "/post_topic", method = RequestMethod.POST)
    public CommonResult<Integer> postTopic(TopicPostDTO topic){
        Integer integer = communityService.postTopic(topic);
        return CommonResult.success(integer);
    }
}
