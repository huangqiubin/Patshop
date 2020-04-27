package com.hqb.patshop.mbg.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sms_topic
 * @author 
 */
@Data
public class SmsTopic implements Serializable {
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
     * 二级话题id
     */
    private Integer secTopicId;

    /**
     * 是否精选话题  0 不是 1 是
     */
    private Integer hotTopic;

    /**
     * 发表话题用户的nickname
     */
    private String userNickname;

    /**
     * 话题热度
     */
    private Double topicHotValue;

    /**
     * 发表话题用户的头像
     */
    private String userAvatar;

    private static final long serialVersionUID = 1L;
}