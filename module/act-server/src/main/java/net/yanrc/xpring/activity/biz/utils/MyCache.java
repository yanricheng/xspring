package net.yanrc.xpring.activity.biz.utils;

import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;

import java.util.concurrent.Callable;

/**
 * @author by MacBook on 2018/3/8
 * @see
 * @since 1.0.0
 */
public class MyCache implements Cache {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        return null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }
}
