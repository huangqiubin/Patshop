package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.domain.BidSaleResult;
import com.hqb.patshop.app.home.domain.MineContentResult;
import com.hqb.patshop.app.home.pojo.BidNumPOJO;
import com.hqb.patshop.app.home.service.MineService;
import com.hqb.patshop.mbg.dao.PmsBidResultDao;
import com.hqb.patshop.mbg.dao.UmsMemberMapper;
import com.hqb.patshop.mbg.model.PmsBidResultModel;
import com.hqb.patshop.mbg.model.UmsMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineServiceImpl implements MineService {
    @Autowired
    UmsMemberMapper memberMapper;
    @Autowired
    PmsBidResultDao bidResultDao;

    /**
     * 我的界面数据
     *
     * @param userName
     * @return
     */
    @Override
    public MineContentResult mineContent(String userName) {
        MineContentResult mineContentResult = new MineContentResult();
        BidNumPOJO bidNumPOJO = new BidNumPOJO();
        UmsMemberDao umsMemberDao = memberMapper.selectUserByUserName(userName);
        int bidCount = bidResultDao.selectCountByUserId(umsMemberDao.getId());
        bidNumPOJO.setBidNum(bidCount);
        bidNumPOJO.setFootPrint(0);
        bidNumPOJO.setOnLooks(0);
        mineContentResult.setMemberDao(umsMemberDao);
        mineContentResult.setBidNumPOJO(bidNumPOJO);
        return mineContentResult;
    }

    /**
     * 获取参拍拍品列表
     *
     * @param userName
     * @return
     */
    @Override
    public BidSaleResult bidSaleContent(String userName) {
        BidSaleResult bidSaleResult = new BidSaleResult();
        UmsMemberDao memberDao = memberMapper.selectUserByUserName(userName);
        List<PmsBidResultModel> bidSaleResultList = bidResultDao.selectAllByUserId(memberDao.getId());
        bidSaleResult.setBidResultModelList(bidSaleResultList);
        return bidSaleResult;
    }
}
