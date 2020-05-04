package com.hqb.patshop.config.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="com.config.constant")
public class ConstantBean {

    private boolean isDebug = false;

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }
}
