package com.hqb.patshop;

import com.hqb.patshop.config.constant.ConstantBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = "com.hqb.patshop.mbg.dao")
@EnableConfigurationProperties({ConstantBean.class})
public class PatshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatshopApplication.class, args);
    }
}
