package com.hqb.patshop.app.login.service;

import com.hqb.patshop.mbg.model.UmsMember;

/**
 * 获取用户信息
 */
public interface MemberService {

    UmsMember getMemberInfo(String userName);

    String getMemberPassword(String userName);
}
