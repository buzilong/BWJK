package com.bwjk.sso.common.handler;

import com.bwjk.common.basedto.ErrorInfo;
import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zxl on 2017/7/12.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorInfo errorInfo = new ErrorInfo();

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo testException(HttpServletRequest request, Exception ex) {
        System.out.println("--Exception回调开始--");
        LOGGER.info("Exception:" + ex.getMessage());
        System.out.println(ex.getMessage());
        System.out.println("--Exception回调结束--");

        errorInfo.setCode("");
        errorInfo.setType("");
        errorInfo.setMessage("");

        return errorInfo;
    }
    
    @ModelAttribute
    public void newUser() {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }
}
