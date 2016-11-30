package net.yanrc.xpring.rpc.service.impl;

import net.yanrc.app.common.result.PresentResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.dal.entity.ConfigProperties;
import net.yanrc.xpring.rpc.manger.ConfigPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
public class ConfigPropertiesServerImpl {
    @Autowired
    private ConfigPropertiesManager configPropertiesManager;

    public Result<List<ConfigProperties>> selectAll() {
        return PresentResult.fromNullable(configPropertiesManager.selectAll());
    }
}
