package com.hqb.patshop.app.login.controller;

import com.hqb.patshop.app.login.service.LoginService;
import com.hqb.patshop.app.login.service.MemberService;
import com.hqb.patshop.common.api.CommonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    MemberService memberService;

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public CommonResult<LoginResult> login(int memberId) {
//        LoginResult loginResult = loginService.login(memberId);
//        if (loginResult.getUmsMemberDao() == null) {
//            return CommonResult.failed();
//        }
//
//        return CommonResult.success(loginResult);
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public CommonResult<String> login(String userName, String password) {
//        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().getId();
//        UmsMemberDao memberInfo = memberService.getMemberInfo(userName);
//        try {
//            if (memberInfo.getPassword().equals(password)) {
//                return CommonResult.success(JWTUtil.sign(userName, password), "login success");
//            } else {
//                throw new UnauthorizedException();
//            }
//        } catch (Exception e) {
//            return CommonResult.unauthorized(null);
//        }
//
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public CommonResult login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Serializable serializable = subject.getSession().getId();
            return CommonResult.success(serializable, "登陆成功");
        } catch (AuthenticationException e) {
            return CommonResult.unauthorized(null);
        }

    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CommonResult unauthorized() {
        return CommonResult.unauthorized(null);
    }

}
