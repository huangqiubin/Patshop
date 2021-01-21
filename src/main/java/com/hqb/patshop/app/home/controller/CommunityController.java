package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.CommunityResult;
import com.hqb.patshop.app.home.domain.HotTopicResult;
import com.hqb.patshop.app.home.dto.TopicPostDTO;
import com.hqb.patshop.app.home.service.CommunityService;
import com.hqb.patshop.app.home.util.FileUtils;
import com.hqb.patshop.common.api.CommonResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @RequestMapping(value = "/hot_topic", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<CommunityResult> content(int position) {
        CommunityResult communityResult = communityService.hotTopicList(position);
        return CommonResult.success(communityResult);
    }

    @RequestMapping(value = "/topic_list", method = RequestMethod.GET)
    public CommonResult<HotTopicResult> hotTopicList() {
        HotTopicResult hotTopicResult = communityService.hotTopicList();
        return CommonResult.success(hotTopicResult);
    }

    @RequestMapping(value = "/post_topic", method = RequestMethod.POST)
    public CommonResult<Integer> postTopic(String topicType, String topicSecType, String topicContent, MultipartFile[] files) {
        System.out.println(files.length);
        StringBuilder imageBuilder = new StringBuilder();
        for (MultipartFile file : files) {
            try {
                FileUtils.saveMultipartFile(imageBuilder, file);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("服务端存储文件异常");
                return CommonResult.failed("服务端存储文件异常");
            }
        }
        TopicPostDTO topic = new TopicPostDTO();
        topic.setTopicType(topicType);
        topic.setTopicSecType(topicSecType);
        topic.setTopicContent(topicContent);
        topic.setTopicImage(imageBuilder.toString());
        Integer integer = communityService.postTopic(topic);
        return CommonResult.success(integer);
    }


}
