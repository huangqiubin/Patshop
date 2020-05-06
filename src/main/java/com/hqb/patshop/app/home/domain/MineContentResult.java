package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.app.home.pojo.BidNumPOJO;
import com.hqb.patshop.mbg.model.UmsMemberDao;

public class MineContentResult {
    //用户基本信息
    private UmsMemberDao memberDao;
    //参拍、足迹、围观
    private BidNumPOJO bidNumPOJO;


    public UmsMemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(UmsMemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public BidNumPOJO getBidNumPOJO() {
        return bidNumPOJO;
    }

    public void setBidNumPOJO(BidNumPOJO bidNumPOJO) {
        this.bidNumPOJO = bidNumPOJO;
    }

    @Override
    public String toString() {
        return "MineContentResult{" +
                "memberDao=" + memberDao +
                ", bidNumPOJO=" + bidNumPOJO +
                '}';
    }
}
