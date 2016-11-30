package net.yanrc.xpring.rpc.manger;

import net.yanrc.xpring.dal.entity.ConfigProperties;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
public interface ConfigPropertiesManager {
    List<ConfigProperties> selectAll();
}
