package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.domain.BidOnLookResult;
import com.hqb.patshop.app.home.domain.BidSaleResult;
import com.hqb.patshop.app.home.domain.MineContentResult;
import com.hqb.patshop.app.home.pojo.BidNumPOJO;
import com.hqb.patshop.app.home.pojo.BidOnLookPOJO;
import com.hqb.patshop.app.home.pojo.BidSalePOJO;
import com.hqb.patshop.app.home.service.MineService;
import com.hqb.patshop.mbg.dao.PmsBidResultDao;
import com.hqb.patshop.mbg.dao.PmsOnLookDao;
import com.hqb.patshop.mbg.dao.UmsMemberDao;
import com.hqb.patshop.mbg.model.BidResultModel;
import com.hqb.patshop.mbg.model.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MineServiceImpl implements MineService {
    @Autowired
    UmsMemberDao memberDao;
    @Autowired
    PmsBidResultDao bidResultDao;
    @Autowired
    PmsOnLookDao onLookDao;

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
        UmsMember umsMemberDao = memberDao.selectUserByUserName(userName);
        //获取参拍数量
        int bidCount = bidResultDao.selectCountByUserId(umsMemberDao.getId());
        //获取围观数量
        int onLookCount = onLookDao.selectCountByUserId(umsMemberDao.getId());
        bidNumPOJO.setBidNum(bidCount);
        bidNumPOJO.setFootPrint(0);
        bidNumPOJO.setOnLooks(onLookCount);
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
        List<BidSalePOJO> bidSaleList = new ArrayList<>();
        UmsMember member = memberDao.selectUserByUserName(userName);
        List<BidResultModel> bidResultModelList = bidResultDao.selectAllResultByUserId(member.getId());
        for (BidResultModel bidResultModel : bidResultModelList) {
            BidSalePOJO bidSalePOJO = new BidSalePOJO();
            bidSalePOJO.setId(bidResultModel.getId());
            bidSalePOJO.setUserId(bidResultModel.getUserId());
            bidSalePOJO.setProductId(bidResultModel.getProductId());
            bidSalePOJO.setPic(bidResultModel.getProductModel().getPic().split(",")[0]);
            bidSalePOJO.setTitle(bidResultModel.getProductModel().getName());
            //参拍人数
            String[] bidCount = bidResultModel.getProductModel().getCurPatUserId().split(",");
            bidSalePOJO.setBids(bidCount.length);
            //参拍状态 0竞拍成功 1竞拍失败 2领先 3落后
            Date endDate = bidResultModel.getProductModel().getBidCountdown();
            long endMillis = endDate.getTime();
            boolean bidState = bidResultModel.getUserId().equals(bidCount[0]);
            if (System.currentTimeMillis() > endMillis) {
                if (bidState) {
                    bidSalePOJO.setBidState("竞拍成功");
                } else {
                    bidSalePOJO.setBidState("竞拍失败");
                }
            } else {
                if (bidState) {
                    bidSalePOJO.setBidState("领先");
                } else {
                    bidSalePOJO.setBidState("落后");
                }
            }
            //当前价格
            if (bidCount.length > 0) {
                String[] bidPrice = bidResultModel.getProductModel().getCurPatCoin().split(",");
                bidSalePOJO.setBidPrice(Double.parseDouble(bidPrice[0]));
            } else {
                bidSalePOJO.setBidPrice(bidResultModel.getProductModel().getStartPrice().doubleValue());
            }
            bidSaleList.add(bidSalePOJO);
        }
        bidSaleResult.setBidResultList(bidSaleList);
        return bidSaleResult;
    }

    @Override
    public BidOnLookResult bidOnLookContent(String userName) {
        BidOnLookResult bidOnLookResult = new BidOnLookResult();
        List<BidOnLookPOJO> onLookList = new ArrayList<>();
        UmsMember member = memberDao.selectUserByUserName(userName);
        List<BidResultModel> bidResultModelList = onLookDao.selectAllResultByUserId(member.getId());
        for (BidResultModel bidResultModel : bidResultModelList) {
            BidOnLookPOJO onLookPOJO = new BidOnLookPOJO();
            onLookPOJO.setId(bidResultModel.getId());
            onLookPOJO.setUserId(bidResultModel.getUserId());
            onLookPOJO.setProductId(bidResultModel.getProductId());
            onLookPOJO.setPic(bidResultModel.getProductModel().getPic().split(",")[0]);
            onLookPOJO.setTitle(bidResultModel.getProductModel().getName());
            //参拍人数
            String[] bidCount = bidResultModel.getProductModel().getCurPatUserId().split(",");
            onLookPOJO.setBids(bidCount.length);
            //参拍状态 0竞拍成功 1竞拍失败 2领先 3落后
            Date endDate = bidResultModel.getProductModel().getBidCountdown();
            long endMillis = endDate.getTime();
            boolean bidState = bidResultModel.getUserId().equals(bidCount[0]);
            if (System.currentTimeMillis() > endMillis) {
                if (bidState) {
                    onLookPOJO.setBidState("竞拍成功");
                } else {
                    onLookPOJO.setBidState("已截拍");
                }
            } else {
                onLookPOJO.setBidState("竞拍中");
            }
            //当前价格
            if (bidCount.length > 0) {
                String[] bidPrice = bidResultModel.getProductModel().getCurPatCoin().split(",");
                onLookPOJO.setBidPrice(Double.parseDouble(bidPrice[0]));
            } else {
                onLookPOJO.setBidPrice(bidResultModel.getProductModel().getStartPrice().doubleValue());
            }
            onLookList.add(onLookPOJO);
        }
        bidOnLookResult.setOnLookList(onLookList);
        return bidOnLookResult;
    }
}
