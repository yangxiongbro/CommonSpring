package com.common.spring.exception.business;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.IBaseAssert;
import com.common.java.exception.base.IExceptionAssertResponseEnum;

import java.text.MessageFormat;

/**
 * <b><code>ICommonBusinessExceptionFactory</code></b>
 * <p/>
 * ICommonBusinessExceptionFactory
 * <p/>
 * <b>Creation Time:</b> 2023/11/10 0:30
 *
 * @author yang xiong
 * @since CommonSpring 1.0
 */
public interface ICommonBusinessExceptionFactory extends IExceptionAssertResponseEnum, IBaseAssert {
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new CommonBusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new CommonBusinessException(this, args, msg, t);
    }
}
