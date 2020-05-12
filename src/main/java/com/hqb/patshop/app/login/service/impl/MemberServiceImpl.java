package com.hqb.patshop.app.login.service.impl;

import com.hqb.patshop.app.login.service.MemberService;
import com.hqb.patshop.mbg.dao.UmsMemberDao;
import com.hqb.patshop.mbg.model.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    UmsMemberDao memberDao;

    @Override
    public UmsMember getMemberInfo(String userName) {
        return memberDao.selectUserByUserName(userName);
    }

    @Override
    public String getMemberPassword(String userName) {
        return memberDao.selectUserByUserName(userName).getPassword();
    }

}
