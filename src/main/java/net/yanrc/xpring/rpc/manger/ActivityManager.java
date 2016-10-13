package net.yanrc.xpring.rpc.manger;

import net.yanrc.xpring.dal.entity.Activity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by yanricheng on 16-10-13.
 */
public interface ActivityManager {
    @CachePut(value = "default", key = "#p0.id")
    Activity add(Activity activity);

    @CachePut(value = "default", key = "#p0.id")
    Activity addSelective(Activity activity);

    @CacheEvict(value = "default", key = "#p0")
    boolean remove(Integer id);

    @CachePut(value = "default", key = "#p0.id")
    Activity editById(Activity activity);

    @CachePut(value = "default", key = "#p0.id")
    Activity editByIdSelective(Activity activity);

    @Cacheable(value = "default", key = "#p0")
    Activity getById(Integer id);
}
