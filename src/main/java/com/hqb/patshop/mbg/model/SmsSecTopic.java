package com.hqb.patshop.mbg.model;

import java.io.Serializable;

import lombok.Data;

/**
 * sms_sec_topic
 *
 * @author
 */
@Data
public class SmsSecTopic implements Serializable {
    /**
     * 二级话题分类主键id
     */
    private Integer id;

    /**
     * 二级话题名称
     */
    private String secTopicName;

    /**
     * 热门话题 0不是 1是
     */
    private Integer isHot;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SmsSecTopic other = (SmsSecTopic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSecTopicName() == null ? other.getSecTopicName() == null : this.getSecTopicName().equals(other.getSecTopicName()))
                && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSecTopicName() == null) ? 0 : getSecTopicName().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SmsSecTopic{" +
                "id=" + id +
                ", secTopicName='" + secTopicName + '\'' +
                ", isHot=" + isHot +
                '}';
    }
}