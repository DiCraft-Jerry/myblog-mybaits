package cn.dicraft.myblog.annotation;

import java.lang.annotation.*;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 22:08
 * @package: cn.dicraft.myblog.annotation
 * @Version: 1.0
 * @Decsription:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimit {
    int seconds();
    int maxCount();
    boolean needLogin()default true;
}