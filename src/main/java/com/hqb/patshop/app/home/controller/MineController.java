package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.BidSaleResult;
import com.hqb.patshop.app.home.domain.MineContentResult;
import com.hqb.patshop.app.home.service.MineService;
import com.hqb.patshop.common.api.CommonResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mine")
public class MineController {

    @Autowired
    MineService mineService;

    /**
     * 获取我的页面内容
     *
     * @return
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<MineContentResult> content(String userName) {
        MineContentResult mineContentResult = mineService.mineContent(userName);
        return CommonResult.success(mineContentResult);
    }

    /**
     * 获取参拍拍品
     *
     * @return
     */
    @RequestMapping(value = "/bid_sale", method = RequestMethod.GET)
    @RequiresAuthentication
    public CommonResult<BidSaleResult> bidSale(String userName) {
        BidSaleResult bidSaleResult = mineService.bidSaleContent(userName);
        return CommonResult.success(bidSaleResult);
    }

}
