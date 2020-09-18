package com.cloud.stall.starter.util;

import com.cloud.stall.starter.constants.enums.ExceptionEnum;
import com.cloud.stall.starter.exception.BusinessException;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.util.function.Supplier;

/**
 * 断言工具类
 *
 * @author baoyw
 */
public class AssertUtil {

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new BusinessException(message);
        }
    }

    public static void isFalse(boolean expression, String message, Integer code) {
        if (expression) {
            throw new BusinessException(code, message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(message);
        }
    }

    public static void isTrue(boolean expression, String message, Integer code) {
        if (!expression) {
            throw new BusinessException(code, message);
        }
    }

    public static void isTrue(boolean expression, ExceptionEnum exceptionEnum) {
        if (!expression) {
            throw new BusinessException(exceptionEnum.getCode(), exceptionEnum.getMessage());
        }
    }

    public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw new BusinessException(nullSafeGet(messageSupplier));
        }
    }

    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new BusinessException(message);
        }
    }

    public static void notNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object == null) {
            throw new BusinessException(nullSafeGet(messageSupplier));
        }
    }

    public static void hasText(@Nullable String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new BusinessException(message);
        }
    }

    public static void hasText(@Nullable String text, Supplier<String> messageSupplier) {
        if (!StringUtils.hasText(text)) {
            throw new BusinessException(nullSafeGet(messageSupplier));
        }
    }

    @Nullable
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
