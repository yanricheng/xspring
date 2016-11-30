package net.yanrc.xpring.rpc.manger.impl;

import net.yanrc.xpring.dal.entity.ConfigPropertity;
import net.yanrc.xpring.dal.mapper.ConfigPropertityMapper;
import net.yanrc.xpring.rpc.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.rpc.manger.ConfigPropertityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
@Service
public class ConfigPropertityManagerImpl implements ConfigPropertityManager {
    @Autowired
    private ConfigPropertityMapper configPropertityMapper;

    @Override
    public List<ConfigPropertity> selectList(ConfigPropertityQueryDto dto) {
        return configPropertityMapper.selectList(dto);
    }
}
