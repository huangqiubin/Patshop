package com.hqb.patshop.mbg.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ums_sign_in
 * @author 
 */
@Data
public class UmsSignInModel implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 签到日期
     */
    private Date signDate;

    /**
     * 奖励拍拍币
     */
    private Integer rewardCoin;

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
        UmsSignInModel other = (UmsSignInModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
            && (this.getRewardCoin() == null ? other.getRewardCoin() == null : this.getRewardCoin().equals(other.getRewardCoin()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getRewardCoin() == null) ? 0 : getRewardCoin().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", signDate=").append(signDate);
        sb.append(", rewardCoin=").append(rewardCoin);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}