package com.hqb.patshop.mbg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  首页banner广告表
 * @Author  QiuBin
 * @Date 2020-03-15 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="sms_home_advertise" )
public class SmsHomeAdvertise  implements Serializable {

	private static final long serialVersionUID =  8431240846470991409L;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "name" )
	private String name;

   	@Column(name = "pic" )
	private String pic;

	/**
	 * 上下线状态：0->下线；1->上线
	 */
   	@Column(name = "status" )
	private Long status;

	/**
	 * 点击数
	 */
   	@Column(name = "click_count" )
	private Long clickCount;

	/**
	 * 下单数
	 */
   	@Column(name = "order_count" )
	private Long orderCount;

	/**
	 * 链接地址
	 */
   	@Column(name = "url" )
	private String url;

	/**
	 * 备注
	 */
   	@Column(name = "note" )
	private String note;

	/**
	 * 排序
	 */
   	@Column(name = "sort" )
	private Long sort;

}
