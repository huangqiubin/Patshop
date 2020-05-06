package com.hqb.patshop.app.home.controller;

import com.hqb.patshop.app.home.domain.ActivityContentResult;
import com.hqb.patshop.app.home.service.ActivityService;
import com.hqb.patshop.common.api.CommonResult;
import com.hqb.patshop.mbg.model.UmsSignInModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    /**
     * 获取活动内容
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/activity_content", method = RequestMethod.GET)
    public CommonResult<ActivityContentResult> getActivityContent(String userName) {
        ActivityContentResult activityContentResult = new ActivityContentResult();
        UmsSignInModel signInModel = activityService.getSignInModel(userName);
        activityContentResult.setSignInModel(signInModel);
        return CommonResult.success(activityContentResult);
    }

    /**
     * 签到接口
     */
    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public CommonResult<Integer> signInReward() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        System.out.println("principal: " + principal);
        UmsSignInModel signInModel = activityService.getSignInModel(principal);
        //第一次签到
        if (signInModel == null) {
            return CommonResult.success(activityService.signInReward(3, principal));
        }
        long millis = signInModel.getSignDate().getTime();
        //连续签到，最高得7个拍拍币
        if (isYestoday(millis)) {
            int rewardCoin = 0;
            if (signInModel.getRewardCoin() + 1 < 7) {
                rewardCoin = signInModel.getRewardCoin() + 1;
            } else {
                rewardCoin = 7;
            }
            return CommonResult.success(activityService.signInReward(rewardCoin, principal));
        } else {
            return CommonResult.success(activityService.signInReward(3, principal));
        }

    }

    //是否是昨天
    public boolean isYestoday(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long zero = cal.getTimeInMillis();
        return (millis > (zero - 86400000)) && (millis < zero);
    }
}
