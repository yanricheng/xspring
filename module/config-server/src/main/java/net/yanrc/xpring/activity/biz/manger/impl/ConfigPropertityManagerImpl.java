package net.yanrc.xpring.activity.biz.manger.impl;

import net.yanrc.xpring.activity.biz.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.activity.biz.manger.ConfigPropertityManager;
import net.yanrc.xpring.activity.domain.ConfigPropertity;
import net.yanrc.xpring.activity.dal.mapper.ConfigPropertityMapper;
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
