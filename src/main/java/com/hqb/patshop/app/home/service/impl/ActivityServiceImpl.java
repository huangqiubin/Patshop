package com.hqb.patshop.app.home.service.impl;

import com.hqb.patshop.app.home.service.ActivityService;
import com.hqb.patshop.mbg.dao.UmsSignInDao;
import com.hqb.patshop.mbg.model.UmsSignInModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    UmsSignInDao signInDao;

    @Override
    public UmsSignInModel getSignInModel(String userName) {
        UmsSignInModel signInModel = signInDao.selectLastByUserName(userName);
        return signInModel;
    }

    @Override
    public int signInReward(int coinNum, String userName) {
        UmsSignInModel signInModel = new UmsSignInModel();
        signInModel.setRewardCoin(coinNum);
        signInModel.setSignDate(new Date());
        signInModel.setUsername(userName);
        return signInDao.insertSelective(signInModel);
    }
}
