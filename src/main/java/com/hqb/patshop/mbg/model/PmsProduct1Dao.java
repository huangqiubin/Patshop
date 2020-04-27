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
 * @Description  商品详细信息
 * @Author  QiuBin
 * @Date 2020-03-21 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="pms_product1" )
public class PmsProduct1Dao implements Serializable {

	private static final long serialVersionUID =  123259043319591457L;

	/**
	 * 主键
	 */
   	@Column(name = "id" )
	private Long id;

	/**
	 * 创建时间
	 */
   	@Column(name = "gmt_create" )
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
   	@Column(name = "gmt_modified" )
	private Date gmtModified;

	/**
	 * 商品分类id
	 */
   	@Column(name = "product_category_id" )
	private Long productCategoryId;

	/**
	 * 商品名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 商品图片
	 */
   	@Column(name = "pic" )
	private String pic;

	/**
	 * 删除状态：0->未删除；1->已删除
	 */
   	@Column(name = "delete_status" )
	private Long deleteStatus;

	/**
	 * 销量
	 */
   	@Column(name = "sale" )
	private Long sale;

	/**
	 * 市场价格
	 */
   	@Column(name = "market_price" )
	private Double marketPrice;

	/**
	 * 当前价格
	 */
	@Column(name = "current_price")
	private Double currentprice;

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
	 * 库存
	 */
   	@Column(name = "stock" )
	private Long stock;

	/**
	 * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
	 */
   	@Column(name = "service_ids" )
	private String service_Ids;

	/**
	 * 商品关键字
	 */
   	@Column(name = "keywords" )
	private String keywords;

	/**
	 * 画册图片，连产品图片限制为5张，以逗号分割
	 */
   	@Column(name = "album_pics" )
	private String albumPics;

	/**
	 * 商品分类名称
	 */
   	@Column(name = "category_name" )
	private String categoryName;

	/**
	 * 出价人数
	 */
   	@Column(name = "bids" )
	private Long bids;

	/**
	 * 围观人数
	 */
   	@Column(name = "onlookers" )
	private Long onlookers;

	/**
	 * 截拍时间
	 */
   	@Column(name = "bid_countdown" )
	private Date bidCountdown;

	/**
	 * 起拍价
	 */
   	@Column(name = "start_price" )
	private Double startPrice;

	/**
	 * 退币比率
	 */
   	@Column(name = "refund_rate" )
	private Integer refundRate;

	/**
	 * 手续费
	 */
   	@Column(name = "handling_fee" )
	private Double handlingFee;

	/**
	 * 加价幅度
	 */
   	@Column(name = "markup" )
	private Double markup;

}
