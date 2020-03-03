package com.hqb.patshop.home.controller;

import com.hqb.patshop.common.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/content")
    @ResponseBody
    public CommonResult<String> content(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","黄秋斌");
        return CommonResult.success("成功");
    }

}
