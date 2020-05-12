package com.hqb.patshop.mbg.dao;

import com.hqb.patshop.mbg.model.UmsMember;

public interface UmsMemberDao {

    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);

    UmsMember selectUserByUserName(String userName);


}