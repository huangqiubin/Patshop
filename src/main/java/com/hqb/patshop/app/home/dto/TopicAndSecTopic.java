package com.hqb.patshop.app.home.dto;

import com.hqb.patshop.mbg.model.SmsSecTopic;
import lombok.Data;

import java.util.Date;

@Data
public class TopicAndSecTopic {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 话题类型0 纯文字 1图文
     */
    private Integer topicType;

    /**
     * 话题内容
     */
    private String topicContent;

    /**
     * 话题图片，以逗号分隔
     */
    private String topicImage;

    /**
     * 发表话题用户id
     */
    private Integer userId;

    /**
     * 发表话题用户昵称
     */
    private String userNickName;

    /**
     * 发表话题用户头像
     */
    private String userAvatar;

    /**
     * 创建话题时间
     */
    private Date createTime;

    /**
     * 话题分类
     */
    private String topicCategory;

    /**
     * 话题标题
     */
    private String topicTitle;

    /**
     * 二级话题标题
     */
    private SmsSecTopic smsSecTopic;

    /**
     * 是否是精选话题
     */
    private Integer hotTopic;

    /**
     * 话题热度
     */
    private Float topicHotValue;
}
