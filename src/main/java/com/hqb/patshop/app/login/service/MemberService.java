package com.hqb.patshop.app.login.service;

import com.hqb.patshop.mbg.model.UmsMemberDao;

/**
 * 获取用户信息
 */
public interface MemberService {

    UmsMemberDao getMemberInfo(String userName);

    String getMemberPassword(String userName);
}
