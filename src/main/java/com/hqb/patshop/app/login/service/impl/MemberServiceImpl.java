package com.hqb.patshop.app.login.service.impl;

import com.hqb.patshop.app.login.service.MemberService;
import com.hqb.patshop.mbg.model.UmsMemberDao;
import com.hqb.patshop.mbg.dao.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    UmsMemberMapper memberMapper;

    @Override
    public UmsMemberDao getMemberInfo(String userName) {
        return memberMapper.selectUserByUserName(userName);
    }

    @Override
    public String getMemberPassword(String userName) {
        return memberMapper.selectUserByUserName(userName).getPassword();
    }

}
