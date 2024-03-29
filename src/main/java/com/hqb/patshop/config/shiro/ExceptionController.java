package com.hqb.patshop.config.shiro;

import com.hqb.patshop.common.api.CommonResult;
import com.hqb.patshop.common.api.IErrorCode;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public CommonResult handle401(ShiroException e) {
        return CommonResult.forbidden(null);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public CommonResult handle401() {
        return CommonResult.forbidden(null);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult globalException(HttpServletRequest request, Throwable ex) {
        return CommonResult.failed(new IErrorCode() {
            @Override
            public long getCode() {
                return getStatus(request).value();
            }

            @Override
            public String getMessage() {
                return ex.getMessage() + " —————— " + ex.getCause();
            }
        });
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
