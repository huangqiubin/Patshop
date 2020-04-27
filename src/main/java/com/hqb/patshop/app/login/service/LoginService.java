package com.hqb.patshop.app.login.service;

import com.hqb.patshop.app.login.domain.LoginResult;

/**
 * 用户登陆service
 */
public interface LoginService {

    LoginResult login(int memberId);
}
