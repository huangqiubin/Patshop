package com.hqb.patshop.app.login.service.impl;

import com.hqb.patshop.app.login.domain.LoginResult;
import com.hqb.patshop.app.login.service.LoginService;
import com.hqb.patshop.mbg.model.UmsMemberDao;
import com.hqb.patshop.mbg.dao.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UmsMemberMapper memberMapper;

    @Override
    public LoginResult login(int memberId) {
        LoginResult loginResult = new LoginResult();
        UmsMemberDao memberDao = memberMapper.selectMember(memberId);
        loginResult.setUmsMemberDao(memberDao);
        return loginResult;
    }
}
