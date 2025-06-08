package com.yy.exception;

/*********************************************************
 ** 未认证异常
 ** <br><br>
 ** Date: Created in 2022/6/20 21:08
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
public class AuthException extends BaseException{
    public AuthException() {
        super();
    }

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthException(Throwable cause) {
        super(cause);
    }

    protected AuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}