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
 * @Description  商品类目表
 * @Author  QiuBin
 * @Date 2020-03-19 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="pms_product_category" )
public class PmsProductCategoryDao implements Serializable {

	private static final long serialVersionUID =  4362505682606176697L;

	/**
	 * 分类id
	 */
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
   	@Column(name = "gmt_modified" )
	private Date gmtModified;

	/**
	 * 分类名称
	 */
   	@Column(name = "category_name" )
	private String categoryName;

	/**
	 * 商品分级
	 */
   	@Column(name = "level" )
	private Long level;

	/**
	 * 上机分类的编号：0表示一级分类
	 */
   	@Column(name = "parent_id" )
	private Long parentId;

	/**
	 * 商品单位
	 */
   	@Column(name = "product_unit" )
	private String productUnit;

	/**
	 * 是否显示在导航栏：0->不显示；1->显示
	 */
   	@Column(name = "nav_status" )
	private Long navStatus;

	/**
	 * 展示状态
	 */
   	@Column(name = "show_status" )
	private Long showStatus;

	/**
	 * 图标
	 */
   	@Column(name = "icon" )
	private String icon;

	/**
	 * 关键字
	 */
   	@Column(name = "keywords" )
	private String keywords;

}
