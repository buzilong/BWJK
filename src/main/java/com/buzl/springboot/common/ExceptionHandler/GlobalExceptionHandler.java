package com.buzl.springboot.common.ExceptionHandler;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zxl on 2017/7/12.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public void testException(HttpServletRequest request, Exception ex) {
        System.out.println("--Exception回调开始--");
        LOGGER.info("Exception:" + ex.getMessage());
        System.out.println(ex.getMessage());
        System.out.println("--Exception回调结束--");
    }
}
