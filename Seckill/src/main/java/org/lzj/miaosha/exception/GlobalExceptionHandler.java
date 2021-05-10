package org.lzj.miaosha.exception;

import org.lzj.miaosha.result.CodeMsg;
import org.lzj.miaosha.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName GlobalExceptionHandler
 * @Description: 处理全局异常
 * @Author Keen
 * @DATE 2021/3/26 11:14
 * @Version 1.0
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    //会自动获取参数
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(HttpServletResponse response, Exception e) {
        e.printStackTrace();
        if(e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return Result.error(ex.getCm());
        } else if(e instanceof BindException) {
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();

            ObjectError error = errors.get(0);
            String message = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(message));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
