package com.hqb.patshop.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * pms_product1
 * @author 
 */
@Data
public class PmsProductModel implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 商品分类id
     */
    private Long productCategoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品图片
     */
    private String pic;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 市场价格
     */
    private BigDecimal marketPrice;

    /**
     * 当前价格
     */
    private BigDecimal currentPrice;

    /**
     * 拍拍币历史价格，多个价格以逗号分隔
     */
    private String historicalPatCoin;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    private String serviceIds;

    /**
     * 商品关键字
     */
    private String keywords;

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    private String albumPics;

    /**
     * 商品分类名称
     */
    private String categoryName;

    /**
     * 出价人数
     */
    private Integer bids;

    /**
     * 围观人数
     */
    private Integer onlookers;

    /**
     * 截拍时间
     */
    private Date bidCountdown;

    /**
     * 起拍价
     */
    private BigDecimal startPrice;

    /**
     * 退币比率
     */
    private Integer refundRate;

    /**
     * 手续费
     */
    private BigDecimal handlingFee;

    /**
     * 加价幅度
     */
    private BigDecimal markup;

    /**
     * 竞拍价格列表，多个价格以逗号分隔
     */
    private String curPatCoin;

    /**
     * 竞拍玩家，多个玩家以逗号分隔
     */
    private String curPatUserNickname;

    /**
     * 竞拍玩家头像，多个头像以逗号分隔
     */
    private String curPatUserAvatar;

    /**
     * 每次加价时间，多个时间以逗号分隔
     */
    private String curPatTime;

    /**
     * 竞拍玩家id，多个id以逗号分隔
     */
    private String curPatUserId;

    private static final long serialVersionUID = 1L;

}