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
 * @Date 2020-04-03 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="ums_member" )
public class UmsMemberDao implements Serializable {

	private static final long serialVersionUID =  9074100673119563084L;

   	@Column(name = "id" )
	private Long id;

   	@Column(name = "member_level_id" )
	private Long memberLevelId;

	/**
	 * 用户名
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 密码
	 */
   	@Column(name = "password" )
	private String password;

	/**
	 * 昵称
	 */
   	@Column(name = "nickname" )
	private String nickname;

	/**
	 * 手机号码
	 */
   	@Column(name = "phone" )
	private String phone;

	/**
	 * 帐号启用状态:0->禁用；1->启用
	 */
   	@Column(name = "status" )
	private Long status;

	/**
	 * 注册时间
	 */
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 头像
	 */
   	@Column(name = "icon" )
	private String icon;

	/**
	 * 性别：0->未知；1->男；2->女
	 */
   	@Column(name = "gender" )
	private Long gender;

	/**
	 * 生日
	 */
   	@Column(name = "birthday" )
	private Date birthday;

	/**
	 * 所在城市
	 */
   	@Column(name = "city" )
	private String city;

	/**
	 * 职业
	 */
   	@Column(name = "job" )
	private String job;

	/**
	 * 个性签名
	 */
   	@Column(name = "personalized_signature" )
	private String personalizedSignature;

	/**
	 * 拍拍币
	 */
   	@Column(name = "pat_coin" )
	private Long patCoin;

	/**
	 * 成长值
	 */
   	@Column(name = "growth" )
	private Long growth;

	/**
	 * 登陆状态
	 */
   	@Column(name = "login_status" )
	private Integer loginStatus;

	/**
	 * 盐
	 */
	@Column(name = "salt")
	private String salt;

}
