package com.hqb.patshop.app.home.service;

import com.hqb.patshop.mbg.model.UmsSignInModel;

public interface ActivityService {

    UmsSignInModel getSignInModel(String userName);

    int signInReward(int coinNum, String userName);
}
