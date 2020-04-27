package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.UmsMemberDao;

public interface UmsMemberMapper {

    UmsMemberDao selectMember(int memberId);

    UmsMemberDao selectUserByUserName(String userName);
}
