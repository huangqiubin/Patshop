package com.hqb.patshop.app.home.service;

import com.hqb.patshop.mbg.model.PmsProductModel;

import java.util.List;

/**
 * 商家管理商品Service
 */
public interface ManageSaleService {

    /**
     * 获取所有商品
     */
    List<PmsProductModel> productList();


    /**
     * 商家端添加商品Service
     *
     * @param name         商品名称
     * @param pic          商品
     * @param marketPrice  市场价
     * @param subTitle     子标题
     * @param categoryName 商品分类名称
     * @param bidCountDown 竞拍截至日期
     * @param startPrice   起拍价
     * @param markUp       加价幅度
     * @param albumsPics   商品图册
     */
    int addProduct(String name, String pic, Double marketPrice,
                   String subTitle, String categoryName,
                   long bidCountDown, Double startPrice, Double markUp, String albumsPics);

    /**
     * 商家端添加商品Service
     *
     * @param name         商品名称
     * @param pic          商品
     * @param marketPrice  市场价
     * @param subTitle     子标题
     * @param categoryName 商品分类名称
     * @param bidCountDown 竞拍截至日期
     * @param startPrice   起拍价
     * @param markUp       加价幅度
     * @param albumsPics   商品图册
     */
    int updateProduct(String name, String pic, Double marketPrice,
                      String subTitle, String categoryName,
                      long bidCountDown, Double startPrice, Double markUp, String albumsPics);

    /**
     * 商家端下架商品
     * @param productId 下架商品id
     * @return 1为下架成功 0为下架失败
     */
    int offProduct(Integer productId);

}
