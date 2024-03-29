package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.ManageSaleContentResult;
import com.hqb.patshop.app.home.service.HomeService;
import com.hqb.patshop.app.home.service.ManageSaleService;
import com.hqb.patshop.app.home.util.FileUtils;
import com.hqb.patshop.common.api.CommonResult;
import com.hqb.patshop.mbg.model.PmsProductModel;
import com.hqb.patshop.mbg.model.SmsHomeProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/manage_sale")
public class ManageSaleController {

    @Autowired
    ManageSaleService manageSaleService;

    /**
     * 管理页面，在拍和截拍商品
     */
    @RequestMapping(value = "/manage_sale", method = RequestMethod.GET)
    public CommonResult<ManageSaleContentResult> manageSaleContent() {
        ManageSaleContentResult manageSaleContentResult = new ManageSaleContentResult();
        List<PmsProductModel> productModelList = manageSaleService.productList();
        List<SmsHomeProductDao> onBidProduct = new ArrayList<>();
        List<SmsHomeProductDao> endBidProduct = new ArrayList<>();
        for (PmsProductModel productModel : productModelList) {
            SmsHomeProductDao bidProduct = getHomeProduct(productModel);
            if (productModel.getBidCountdown().compareTo(new Date()) > 0 && productModel.getDeleteStatus() == 0) {
                //没截拍
                onBidProduct.add(bidProduct);
            } else {
                //截拍了
                endBidProduct.add(bidProduct);
            }
        }
        manageSaleContentResult.setOnProductList(onBidProduct);
        manageSaleContentResult.setEndProductList(endBidProduct);
        return CommonResult.success(manageSaleContentResult);
    }

    /**
     * 详细商品信息转换成首页商品信息
     */
    private SmsHomeProductDao getHomeProduct(PmsProductModel productModel) {
        SmsHomeProductDao homeProductDao = new SmsHomeProductDao();
        homeProductDao.setProductId(productModel.getId());
        homeProductDao.setBidCount(productModel.getBids().longValue());
        homeProductDao.setCategoryName(productModel.getCategoryName());
        homeProductDao.setMarketPrice(productModel.getMarketPrice().doubleValue());
        String bidCoin = productModel.getCurPatCoin().split(",")[0];
        homeProductDao.setPatPrice(Double.parseDouble(bidCoin.length() == 0 ? "0" : bidCoin));
        homeProductDao.setPic(productModel.getPic());
        homeProductDao.setProductName(productModel.getName());
        homeProductDao.setDeleteStatus(productModel.getDeleteStatus());
        return homeProductDao;
    }

    /**
     * 商家发拍接口
     */
    @RequestMapping(value = "/add_product", method = RequestMethod.POST)
    public CommonResult<Integer> addProduct(String name, MultipartFile[] pics, Double marketPrice,
                                            String subTitle, String categoryName,
                                            long bidCountDown, Double startPrice, Double markUp, MultipartFile[] albumsPics) {
        String picName = getPicName(pics);
        if (picName.length() == 0) {
            return CommonResult.failed("商品首页图不能为空哦～");
        }
        String albumPic = getPicName(albumsPics);
        if (albumPic.length() == 0) {
            return CommonResult.failed("商品相册集不能为空哦～");
        }
        int result = manageSaleService.addProduct(name, picName, marketPrice, subTitle, categoryName,
                bidCountDown, startPrice, markUp, albumPic);
        return CommonResult.success(result);
    }

    @RequestMapping(value = "/update_product", method = RequestMethod.POST)
    public CommonResult<Integer> updateProduct(String name, MultipartFile[] pics, Double marketPrice,
                                               String subTitle, String categoryName,
                                               long bidCountDown, Double startPrice, Double markUp, MultipartFile[] albumsPics) {
        String picName = getPicName(pics);
        if (picName.length() == 0) {
            return CommonResult.failed("商品首页图不能为空哦～");
        }
        String albumPic = getPicName(albumsPics);
        if (albumPic.length() == 0) {
            return CommonResult.failed("商品相册集不能为空哦～");
        }
        int result = manageSaleService.updateProduct(name, picName, marketPrice, subTitle, categoryName,
                bidCountDown, startPrice, markUp, albumPic);
        return CommonResult.success(result);
    }

    /**
     * 下架商品
     */
    @RequestMapping(value = "/off_product", method = RequestMethod.GET)
    public CommonResult<Integer> offProduct(Integer productId) {
        int result = manageSaleService.offProduct(productId);
        return CommonResult.success(result);
    }

    private String getPicName(MultipartFile[] pics) {
        StringBuilder imageBuilder = new StringBuilder();
        for (MultipartFile file : pics) {
            try {
                FileUtils.saveMultipartFile(imageBuilder, file);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("服务端存储文件异常");
                return "";
            }
        }
        return imageBuilder.toString();
    }
}
