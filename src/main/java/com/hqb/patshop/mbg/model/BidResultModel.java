package com.hqb.patshop.mbg.model;

import lombok.Data;

/**
 * 联合查询
 * 商品详情+用户id
 */
@Data
public class BidResultModel {

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
     * 商品信息
     */
    private PmsProductModel productModel;
}
