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
 * @Date 2020-03-15 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="sms_home_hot" )
public class SmsHomeHot  implements Serializable {

	private static final long serialVersionUID =  7963697225996634639L;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "gmt_create" )
	private Date gmtCreate;

   	@Column(name = "gmt_modified" )
	private Date gmtModified;

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

}
