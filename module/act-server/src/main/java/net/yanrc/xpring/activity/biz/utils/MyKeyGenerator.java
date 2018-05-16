package net.yanrc.xpring.activity.biz.utils;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @author by MacBook on 2018/3/7
 * @see
 * @since 1.0.0
 */
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getClass().getName());
        sb.append(method.getName());
        for (Object obj : objects) {
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
