package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.domain.HomeBidProductResult;
import com.hqb.patshop.app.home.domain.HomeContentResult;
import com.hqb.patshop.app.home.domain.HomeHotBidResult;
import com.hqb.patshop.app.home.domain.ProductDetailResult;
import com.hqb.patshop.app.home.service.HomeService;
import com.hqb.patshop.mbg.dao.PmsProductDao;
import com.hqb.patshop.mbg.dao.SmsHomeAdvertiseMapper;
import com.hqb.patshop.mbg.dao.UmsMemberDao;
import com.hqb.patshop.mbg.model.PmsProductModel;
import com.hqb.patshop.mbg.model.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    SmsHomeAdvertiseMapper homeAdvertiseMapper;
    @Autowired
    PmsProductDao productDao;
    @Autowired
    UmsMemberDao memberDaor;

    @Override
    public HomeContentResult content() {
        HomeContentResult homeContentResult = new HomeContentResult();
        // 首页广告轮播
        homeContentResult.setHomeAdvertiseList(homeAdvertiseMapper.selectHomeAdvertise());
        // 首页分类类目
        homeContentResult.setProductCategoryDaoList(homeAdvertiseMapper.selectAllProductCategory());

        return homeContentResult;
    }

    @Override
    public HomeBidProductResult homeBidProduct(String categoryName) {
        HomeBidProductResult homeBidProductResult = new HomeBidProductResult();
        homeBidProductResult.setHomeProductDaoList(homeAdvertiseMapper.selectBidProduct(categoryName));
        return homeBidProductResult;
    }

    @Override
    public HomeHotBidResult homeHotProduct() {
        HomeHotBidResult homeHotBidResult = new HomeHotBidResult();
        homeHotBidResult.setHomeProductDaoList(homeAdvertiseMapper.selectAllHomeHot());
        return homeHotBidResult;
    }

    @Override
    public ProductDetailResult productDetail(long productId) {
        ProductDetailResult productDetailResult = new ProductDetailResult();
        productDetailResult.setPmsProductModel(productDao.selectByPrimaryKey(productId));
        return productDetailResult;
    }

    /**
     * 悲观锁竞拍
     *
     * @param productId
     * @param bidPatCoin
     * @param userName
     * @return -1用户不存在 1竞拍结束 2竞拍失败 3重复出价 4出价过低 0竞拍成功
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Integer bidProduct(long productId, Double bidPatCoin, String userName) {
        UmsMember memberDao = memberDaor.selectUserByUserName(userName);
        if (memberDao == null) {
            return -1;//用户不存在
        }
        PmsProductModel productModel = productDao.selectByPrimaryKeyForUpdate(productId);
        //判断是否截拍
        Date endDate = productModel.getBidCountdown();
        Date nowDate = new Date();
        if (endDate.getTime() < nowDate.getTime()) {
            return 1;//竞拍结束
        }
        //判断是否是同一用户重复出价
        String userIdStr = productModel.getCurPatUserId().split(",")[0];
        int userId = Integer.parseInt(userIdStr);
        if (memberDao.getId() == userId) {
            return 3;//同一用户重复出价
        }
        //判断竞拍价格
        String curPatCoinStr = productModel.getCurPatCoin().split(",")[0];
        Double curPatCoin = Double.parseDouble(curPatCoinStr);
        if (curPatCoin >= bidPatCoin) {
            return 4;//出价过小
        }
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
        productModel.setCurPatCoin(bidPatCoin + "," + productModel.getCurPatCoin());
        productModel.setCurPatUserNickname(memberDao.getNickname() + "," + productModel.getCurPatUserNickname());
        productModel.setCurPatUserAvatar(memberDao.getIcon() + "," + productModel.getCurPatUserAvatar());
        productModel.setCurPatTime(dateFormat.format(nowDate) + "," + productModel.getCurPatTime());
        productModel.setCurPatUserId(memberDao.getId() + "," + productModel.getCurPatUserId());
        productModel.setCurrentPrice(BigDecimal.valueOf(bidPatCoin));
        int result = productDao.updateByPrimaryKeySelective(productModel);
        if (result > 0) {
            return 0;//竞拍成功
        } else {
            return 2;//竞拍失败
        }
    }


}
