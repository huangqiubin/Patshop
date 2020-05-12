package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.UmsSignInModel;

public class ActivityContentResult {

    private UmsSignInModel signInModel;
    private boolean isYesterday;//是否是昨天连续签到
    private boolean hasTodaySign;//今天是否有签到

    public UmsSignInModel getSignInModel() {
        return signInModel;
    }

    public void setSignInModel(UmsSignInModel signInModel) {
        this.signInModel = signInModel;
    }

    public boolean isYesterday() {
        return isYesterday;
    }

    public void setYesterday(boolean yesterday) {
        isYesterday = yesterday;
    }

    public boolean isHasTodaySign() {
        return hasTodaySign;
    }

    public void setHasTodaySign(boolean hasTodaySign) {
        this.hasTodaySign = hasTodaySign;
    }

    @Override
    public String toString() {
        return "ActivityContentResult{" +
                "signInModel=" + signInModel +
                ", isYesterday=" + isYesterday +
                ", hasTodaySign=" + hasTodaySign +
                '}';
    }
}
