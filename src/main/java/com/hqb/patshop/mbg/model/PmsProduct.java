package com.hqb.patshop.mbg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  qiubin
 * @Date 2020-03-07 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="pms_product" )
public class PmsProduct  implements Serializable {

	private static final long serialVersionUID =  367315542373026593L;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "gmt_create" )
	private Date gmtCreate;

   	@Column(name = "gmt_modified" )
	private Date gmtModified;

   	@Column(name = "brand_id" )
	private Long brandId;

   	@Column(name = "product_category_id" )
	private Long productCategoryId;

   	@Column(name = "feight_template_id" )
	private Long feightTemplateId;

   	@Column(name = "product_attribute_category_id" )
	private Long productAttributeCategoryId;

	/**
	 * 商品名称
	 */
   	@Column(name = "name" )
	private String name;

   	@Column(name = "pic" )
	private String pic;

	/**
	 * 删除状态：0->未删除；1->已删除
	 */
   	@Column(name = "delete_status" )
	private Long deleteStatus;

	/**
	 * 上架状态：0->下架；1->上架
	 */
   	@Column(name = "publish_status" )
	private Long publishStatus;

	/**
	 * 新品状态:0->不是新品；1->新品
	 */
   	@Column(name = "new_status" )
	private Long newStatus;

	/**
	 * 推荐状态；0->不推荐；1->推荐
	 */
   	@Column(name = "recommand_status" )
	private Long recommandStatus;

	/**
	 * 审核状态：0->未审核；1->审核通过
	 */
   	@Column(name = "verify_status" )
	private Long verifyStatus;

	/**
	 * 排序
	 */
   	@Column(name = "sort" )
	private Long sort;

	/**
	 * 销量
	 */
   	@Column(name = "sale" )
	private Long sale;

	/**
	 * 价格
	 */
   	@Column(name = "price" )
	private Double price;

	/**
	 * 拍拍币历史价格，多个价格以逗号分隔
	 */
   	@Column(name = "historical_pat_coin" )
	private String historicalPatCoin;

	/**
	 * 副标题
	 */
   	@Column(name = "sub_title" )
	private String subTitle;

	/**
	 * 商品描述
	 */
   	@Column(name = "description" )
	private String description;

	/**
	 * 库存
	 */
   	@Column(name = "stock" )
	private Long stock;

	/**
	 * 单位
	 */
   	@Column(name = "unit" )
	private String unit;

	/**
	 * 商品重量，默认为克
	 */
   	@Column(name = "weight" )
	private Double weight;

	/**
	 * 是否为预告商品：0->不是；1->是
	 */
   	@Column(name = "preview_status" )
	private Long previewStatus;

	/**
	 * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
	 */
   	@Column(name = "service_ids" )
	private String serviceIds;

	/**
	 * 商品关键字
	 */
   	@Column(name = "keywords" )
	private String keywords;

   	@Column(name = "note" )
	private String note;

	/**
	 * 画册图片，连产品图片限制为5张，以逗号分割
	 */
   	@Column(name = "album_pics" )
	private String albumPics;

   	@Column(name = "detail_title" )
	private String detailTitle;

   	@Column(name = "detail_desc" )
	private String detailDesc;

	/**
	 * 促销开始时间
	 */
   	@Column(name = "promotion_start_time" )
	private Date promotionStartTime;

	/**
	 * 促销结束时间
	 */
   	@Column(name = "promotion_end_time" )
	private Date promotionEndTime;

	/**
	 * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
	 */
   	@Column(name = "promotion_type" )
	private Long promotionType;

	/**
	 * 品牌名称
	 */
   	@Column(name = "brand_name" )
	private String brandName;

	/**
	 * 商品分类名称
	 */
   	@Column(name = "product_category_name" )
	private String productCategoryName;

}
