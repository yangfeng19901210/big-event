package com.yy.exception;
import com.yy.pojo.Result;
import io.gitee.loulan_yxq.owner.core.exception.AssertException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理断言异常，并返回数据
     *
     * @param
     * @return
     * @throws
     * @author :loulan
     */
    @ExceptionHandler({IllegalArgumentException.class, AssertException.class,BusinessException.class, BaseException.class})
    public Result handlerAssertException(Exception ex) {
        log.error("发生业务异常", ex);
        return Result.error(ex.getMessage());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handlerException(ConstraintViolationException ex) {
        log.error("发生异常", ex);
        return Result.error(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }
}
