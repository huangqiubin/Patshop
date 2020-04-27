package com.hqb.patshop.app.login.domain;

import com.hqb.patshop.mbg.model.UmsMemberDao;

/**
 * 登陆返回信息信息
 */
public class LoginResult {

    /**
     * 会员基本信息
     */
    private UmsMemberDao umsMemberDao;

    public UmsMemberDao getUmsMemberDao() {
        return umsMemberDao;
    }

    public void setUmsMemberDao(UmsMemberDao umsMemberDao) {
        this.umsMemberDao = umsMemberDao;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "umsMemberDao=" + umsMemberDao +
                '}';
    }
}
