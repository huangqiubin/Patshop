package com.hqb.patshop.app.home.domain;

import com.hqb.patshop.mbg.model.UmsSignInModel;

public class ActivityContentResult {

    private UmsSignInModel signInModel;

    public UmsSignInModel getSignInModel() {
        return signInModel;
    }

    public void setSignInModel(UmsSignInModel signInModel) {
        this.signInModel = signInModel;
    }

    @Override
    public String toString() {
        return "ActivityContentResult{" +
                "signInModel=" + signInModel +
                '}';
    }
}
