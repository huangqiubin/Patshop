package com.hqb.patshop.app.login.domain;

import com.hqb.patshop.mbg.model.UmsMember;

import java.io.Serializable;

/**
 * 登陆返回信息信息
 */
public class LoginResult {

    /**
     * 会员基本信息
     */
    private UmsMember umsMemberDao;

    /**
     * 会员登陆sessionId
     */
    private Serializable serializable;

    public UmsMember getUmsMemberDao() {
        return umsMemberDao;
    }

    public void setUmsMemberDao(UmsMember umsMemberDao) {
        this.umsMemberDao = umsMemberDao;
    }

    public Serializable getSerializable() {
        return serializable;
    }

    public void setSerializable(Serializable serializable) {
        this.serializable = serializable;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "umsMemberDao=" + umsMemberDao +
                ", serializable=" + serializable +
                '}';
    }
}
