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
 * @Author  QiuBin
 * @Date 2020-03-20 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="sms_home_product" )
public class SmsHomeProductDao implements Serializable {

	private static final long serialVersionUID =  6747045451743471427L;

   	@Column(name = "id" )
	private Long id;

	/**
	 * 创建日期
	 */
   	@Column(name = "gmt_create" )
	private Date gmtCreate;

	/**
	 * 修改日期
	 */
   	@Column(name = "gmt_modify" )
	private Date gmtModify;

	/**
	 * 商品id
	 */
   	@Column(name = "product_id" )
	private Long productId;

	/**
	 * 商品名称
	 */
   	@Column(name = "product_name" )
	private String productName;

	/**
	 * 商品分类名
	 */
   	@Column(name = "category_name" )
	private String categoryName;

	/**
	 * 商品图
	 */
   	@Column(name = "pic" )
	private String pic;

	/**
	 * 市场价
	 */
   	@Column(name = "market_price" )
	private Double marketPrice;

	/**
	 * 拍拍币价格
	 */
   	@Column(name = "pat_price" )
	private Double patPrice;

	/**
	 * 出价次数
	 */
   	@Column(name = "bid_count" )
	private Long bidCount;

   	private Integer deleteStatus;


}
