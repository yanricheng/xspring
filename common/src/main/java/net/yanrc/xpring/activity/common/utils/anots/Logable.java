package net.yanrc.xpring.activity.common.utils.anots;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yanricheng on 16-10-25.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface  Logable {
    boolean start() default false;
    boolean end() default false;

}
