package net.yanrc.xpring.activity.common.utils.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;

/**
 * Created by yanricheng on 16-10-21.
 */
public class FixedCacheErrorHandler extends SimpleCacheErrorHandler {
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        System.out.println(exception.fillInStackTrace());
        cache.evict(key);
        System.out.println("clean cache ...");
    }
}
