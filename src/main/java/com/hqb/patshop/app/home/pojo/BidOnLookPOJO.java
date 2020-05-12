package com.hqb.patshop.app.home.pojo;

public class BidOnLookPOJO {
    /**
     * 参拍表id
     */
    private Long id;

    /**
     * 用户userId
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品title
     */
    private String title;

    /**
     * 商品图片
     */
    private String pic;

    /**
     * 出价人数
     */
    private Integer bids;

    /**
     * 竞拍价格
     */
    private Double bidPrice;

    /**
     * 竞拍状态
     */
    private String bidState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getBids() {
        return bids;
    }

    public void setBids(Integer bids) {
        this.bids = bids;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidState() {
        return bidState;
    }

    public void setBidState(String bidState) {
        this.bidState = bidState;
    }

    @Override
    public String toString() {
        return "BisOnLookPOJO{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", bids=" + bids +
                ", bidPrice=" + bidPrice +
                ", bidState='" + bidState + '\'' +
                '}';
    }
}
