package com.common.spring.exception.business;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.IExceptionAssertResponseEnum;

/**
 * <b><code>CommonBusinessException</code></b>
 * <p/>
 * CommonBusinessException
 * <p/>
 * <b>Creation Time:</b> 2023/11/10 0:29
 *
 * @author yang xiong
 * @since CommonSpring 1.0
 */
public class CommonBusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public CommonBusinessException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message) {
        super(exceptionAssertResponseEnum, args, message);
    }

    public CommonBusinessException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message, Throwable cause) {
        super(exceptionAssertResponseEnum, args, message, cause);
    }
}
