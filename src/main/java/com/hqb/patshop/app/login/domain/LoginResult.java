package com.hqb.patshop.app.login.domain;

import com.hqb.patshop.mbg.model.UmsMember;

/**
 * 登陆返回信息信息
 */
public class LoginResult {

    /**
     * 会员基本信息
     */
    private UmsMember umsMemberDao;

    public UmsMember getUmsMemberDao() {
        return umsMemberDao;
    }

    public void setUmsMemberDao(UmsMember umsMemberDao) {
        this.umsMemberDao = umsMemberDao;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "umsMemberDao=" + umsMemberDao +
                '}';
    }
}
