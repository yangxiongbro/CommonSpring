package com.common.spring.exception.business;

/**
 * <b><code>CommonBusinessResponseEnum</code></b>
 * <p/>
 * CommonBusinessResponseEnum
 * <p/>
 * <b>Creation Time:</b> 2023/11/10 0:31
 *
 * @author yang xiong
 * @since CommonSpring 1.0
 */
public enum CommonBusinessResponseEnum implements ICommonBusinessExceptionFactory {
    SERVLET_EXCEPTION(5000010, null),

    /**
     * NoHandlerFoundException 异常
     */
    NO_HANDLER_FOUND_EXCEPTION(5000011, null),

    /**
     * HttpRequestMethodNotSupportedException 异常
     */
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(5000012, null),

    /**
     * HttpMediaTypeNotSupportedException 异常
     */
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION(5000013, null),

    /**
     * MissingPathVariableException 异常
     */
    MISSING_PATH_VARIABLE_EXCEPTION(5000014, null),

    /**
     * MissingServletRequestParameterException 异常
     */
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(5000015, null),

    /**
     * TypeMismatchException 异常
     */
    TYPE_MISMATCH_EXCEPTION(5000016, null),

    /**
     * HttpMessageNotReadableException 异常
     */
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION(5000017, null),

    /**
     * HttpMessageNotWritableException 异常
     */
    HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION(5000018, null),

    /**
     * HttpMediaTypeNotAcceptableException 异常
     */
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION(5000019, null),

    /**
     * ServletRequestBindingException 异常
     */
    SERVLET_REQUEST_BINDING_EXCEPTION(5000020, null),

    /**
     * ConversionNotSupportedException 异常
     */
    CONVERSION_NOT_SUPPORTED_EXCEPTION(5000021, null),

    /**
     * MissingServletRequestPartException 异常
     */
    MISSING_SERVLET_REQUEST_PART_EXCEPTION(5000022, null),

    /**
     * AsyncRequestTimeoutException 异常
     */
    ASYNC_REQUEST_TIMEOUT_EXCEPTION(5000023, null);

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    CommonBusinessResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
