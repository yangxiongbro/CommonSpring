package com.common.spring.exception;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.business.CommonResponseEnum;
import com.common.java.response.BaseResponse;
import com.common.java.response.ER;
import com.common.java.utils.StringsUtils;
import com.common.spring.exception.business.CommonBusinessResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * <b><code>GlobalExceptionHandler</code></b>
 * <p/>
 * 全局异常处理
 * <p/>
 * <b>Creation Time:</b> 2023/11/9 22:16
 *
 * @author yang xiong
 * @since CommonSpring 1.0
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 获取国际化消息
     *
     * @param e 异常
     * @return
     */
    public String getMessage(BaseException e) {
//        String code = "response." + e.getExceptionAssertResponseEnum().toString();
//        String message = unifiedMessageSource.getMessage(code, e.getArgs());
//        if (message == null || message.isEmpty()) {
//            return e.getMessage();
//        }

        return e.getMessage();
    }

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
//    @ExceptionHandler(value = BusinessException.class)
//    @ResponseBody
//    public BaseResponse handleBusinessException(BaseException e) {
//        log.error("{}", e.getMessage());
//
//        return new ER(e.getExceptionAssertResponseEnum().getCode(), getMessage(e));
//    }

    /**
     * 自定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResponse handleBaseException(BaseException e) {
        log.error("GlobalExceptionHandler#handleBaseException: {}", e);
        return new ER(e.getExceptionAssertResponseEnum().getCode(), getMessage(e));
    }

    /**
     * Controller上一层相关异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    @ResponseBody
    public BaseResponse handleServletException(Exception e) {
        log.error("GlobalExceptionHandler#handleServletException: {}", e);
        CommonBusinessResponseEnum commonBusinessResponseEnum = CommonBusinessResponseEnum.SERVLET_EXCEPTION;
        try {
            commonBusinessResponseEnum = CommonBusinessResponseEnum.valueOf(StringsUtils.upperCamelCase2allCapsCase(e.getClass().getSimpleName()));
        } catch (IllegalArgumentException e1) {
            log.error("class [{}] not defined in enum {}", e.getClass().getName(), CommonBusinessResponseEnum.class.getName());
        }
        return new ER(commonBusinessResponseEnum.getCode(), commonBusinessResponseEnum.toString());
    }


    /**
     * 参数绑定/校验异常，将校验失败的所有异常组合成一条错误信息
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            BindException.class,
            MethodArgumentNotValidException.class
    })
    @ResponseBody
    public BaseResponse handleBindException(BindException e) {
        log.error("GlobalExceptionHandler#handleBindException: {}", e);
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
        }
        return new ER(CommonResponseEnum.ARGUE_ERROR.getCode(), msg.substring(2));
    }

    /**
     * 未定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleException(Exception e) {
        log.error("GlobalExceptionHandler#handleException: {}", e);
        return new ER(CommonResponseEnum.INTERNAL_SERVER_ERROR.getCode(), CommonResponseEnum.INTERNAL_SERVER_ERROR.toString());
    }

}
