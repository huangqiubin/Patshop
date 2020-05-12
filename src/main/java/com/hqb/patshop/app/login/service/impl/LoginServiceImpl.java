package com.hqb.patshop.app.login.service.impl;

import com.hqb.patshop.app.login.domain.LoginResult;
import com.hqb.patshop.app.login.service.LoginService;
import com.hqb.patshop.mbg.dao.UmsMemberDao;
import com.hqb.patshop.mbg.model.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UmsMemberDao memberDao;

    @Override
    public LoginResult login(int memberId) {
        LoginResult loginResult = new LoginResult();
        UmsMember member = memberDao.selectByPrimaryKey((long) memberId);
        loginResult.setUmsMemberDao(member);
        return loginResult;
    }
}
