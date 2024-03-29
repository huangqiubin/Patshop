package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.service.ManageSaleService;
import com.hqb.patshop.mbg.dao.PmsProductCategoryDao;
import com.hqb.patshop.mbg.dao.PmsProductDao;
import com.hqb.patshop.mbg.model.PmsProductCategory;
import com.hqb.patshop.mbg.model.PmsProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ManageSaleServiceImpl implements ManageSaleService {

    @Autowired
    PmsProductDao productDao;
    @Autowired
    PmsProductCategoryDao productCategoryDao;

    @Override
    public List<PmsProductModel> productList() {
        return productDao.selectAllDesc();
    }

    @Override
    public int addProduct(String name, String pic, Double marketPrice, String subTitle, String categoryName,
                          long bidCountDown, Double startPrice, Double markUp, String albumsPics) {
        PmsProductModel productModel = makeNewProduct(name, pic, marketPrice, subTitle, categoryName, bidCountDown, startPrice, markUp, albumsPics);
        return productDao.insert(productModel);
    }

    @Override
    public int updateProduct(String name, String pic, Double marketPrice, String subTitle, String categoryName,
                             long bidCountDown, Double startPrice, Double markUp, String albumsPics) {
        PmsProductModel productModel = makeNewProduct(name, pic, marketPrice, subTitle, categoryName, bidCountDown, startPrice, markUp, albumsPics);
        return productDao.updateByPrimaryKeySelective(productModel);
    }

    @Override
    public int offProduct(Integer productId) {
        PmsProductModel productModel = new PmsProductModel();
        productModel.setId(productId.longValue());
        productModel.setDeleteStatus(1);
        return productDao.updateByPrimaryKeySelective(productModel);
    }

    private PmsProductModel makeNewProduct(String name, String pic, Double marketPrice, String subTitle, String categoryName, long bidCountDown, Double startPrice, Double markUp, String albumsPics) {
        PmsProductModel productModel = new PmsProductModel();
        productModel.setName(name);
        productModel.setPic(pic);
        productModel.setMarketPrice(new BigDecimal(marketPrice));
        productModel.setSubTitle(subTitle);
        productModel.setKeywords("");
        productModel.setCategoryName(categoryName);
        PmsProductCategory productCategory = productCategoryDao.selectByCategoryName(categoryName);
        productModel.setProductCategoryId(productCategory.getId());
        Date countDown = new Date(bidCountDown);
        productModel.setBidCountdown(countDown);
        productModel.setStartPrice(new BigDecimal(startPrice));
        productModel.setMarkup(new BigDecimal(markUp));
        productModel.setAlbumPics(albumsPics);

        productModel.setGmtCreate(new Date());
        productModel.setGmtModified(new Date());
        productModel.setDeleteStatus(0);
        productModel.setSale(200);
        productModel.setCurrentPrice(new BigDecimal(startPrice));
        productModel.setHistoricalPatCoin("");
        productModel.setStock(999);
        productModel.setServiceIds("1,2,3");
        productModel.setBids(0);
        productModel.setOnlookers(0);
        productModel.setRefundRate(20);
        productModel.setHandlingFee(new BigDecimal(1));
        productModel.setCurPatCoin("");
        productModel.setCurPatUserNickname("");
        productModel.setCurPatUserAvatar("");
        productModel.setCurPatTime("");
        productModel.setCurPatUserId("");
        return productModel;
    }
}
