package com.hqb.patshop.mbg.model;

import java.io.Serializable;
import lombok.Data;

/**
 * pms_bid_result
 * @author 
 */
@Data
public class PmsBidResultModel implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 竞拍结果 0竞拍成功 1竞拍失败 2领先 3落后
     */
    private Integer bidResult;

    /**
     * 商品成交最终价格
     */
    private Double productBidCoin;

    /**
     * 竞拍商品
     */
    private String productIcon;

    /**
     * 竞拍次数
     */
    private Integer productBidNum;

    /**
     * 商品标题介绍
     */
    private String productTitle;

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
        PmsBidResultModel other = (PmsBidResultModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getBidResult() == null ? other.getBidResult() == null : this.getBidResult().equals(other.getBidResult()))
            && (this.getProductBidCoin() == null ? other.getProductBidCoin() == null : this.getProductBidCoin().equals(other.getProductBidCoin()))
            && (this.getProductIcon() == null ? other.getProductIcon() == null : this.getProductIcon().equals(other.getProductIcon()))
            && (this.getProductBidNum() == null ? other.getProductBidNum() == null : this.getProductBidNum().equals(other.getProductBidNum()))
            && (this.getProductTitle() == null ? other.getProductTitle() == null : this.getProductTitle().equals(other.getProductTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getBidResult() == null) ? 0 : getBidResult().hashCode());
        result = prime * result + ((getProductBidCoin() == null) ? 0 : getProductBidCoin().hashCode());
        result = prime * result + ((getProductIcon() == null) ? 0 : getProductIcon().hashCode());
        result = prime * result + ((getProductBidNum() == null) ? 0 : getProductBidNum().hashCode());
        result = prime * result + ((getProductTitle() == null) ? 0 : getProductTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append(", bidResult=").append(bidResult);
        sb.append(", productBidCoin=").append(productBidCoin);
        sb.append(", productIcon=").append(productIcon);
        sb.append(", productBidNum=").append(productBidNum);
        sb.append(", productTitle=").append(productTitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}