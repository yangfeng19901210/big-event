package com.yy.config;
import com.yy.common.response.Result;
import com.yy.exception.AuthException;
import com.yy.exception.BaseException;
import com.yy.exception.BusinessException;
import io.gitee.loulan_yxq.owner.core.exception.AssertException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理常见异常
     * @param
     * @return
     * @throws
     * @author :loulan
     */
    @ExceptionHandler({IllegalArgumentException.class, AssertException.class, BusinessException.class, BaseException.class})
    public Result handlerCommonException(Exception ex) {
        log.error("发生业务异常", ex);
        return Result.error(ex.getMessage());
    }
    // 处理请求体校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error ->
//                errors.put(error.getField(), error.getDefaultMessage()));
        log.error("参数校验异常", ex);
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.error(message);
    }
    /**
    * @description 处理参数校验异常
    * @author yangFeng
    * @date 2025/6/8 16:20
    * @param ex
    * @return com.yy.common.response.Result
    */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handlerValidationException(ConstraintViolationException ex) {
        log.error("发生异常", ex);
        return Result.error(ex.getMessage());
    }
    /**
    * @description 处理token认证异常
    * @author yangFeng
    * @date 2025/6/8 16:20
    * @param ex
    * @return com.yy.common.response.Result
    */
    @ExceptionHandler(AuthException.class)
    public Result handlerAuthException(AuthException ex) {
        log.error("发生异常", ex);
        return Result.error(401,ex.getMessage());
    }
    /**
    * @description 处理未知异常（最终的兜底处理）
    * @author yangFeng
    * @date 2025/6/8 16:21
    * @param e
    * @return com.yy.common.response.Result
    */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }
}
