package net.yanrc.xpring.rpc.manger.impl;

import net.yanrc.xpring.dal.entity.ConfigProperties;
import net.yanrc.xpring.dal.mapper.ConfigPropertiesMapper;
import net.yanrc.xpring.rpc.manger.ConfigPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
@Service
public class ConfigPropertiesManagerImpl implements ConfigPropertiesManager {
    @Autowired
    ConfigPropertiesMapper configPropertiesMapper;

    @Override
    public List<ConfigProperties> selectAll() {
        return null;
    }
}
