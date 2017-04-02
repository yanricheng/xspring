package net.yanrc.xpring.activity.biz.service.impl;

import com.google.common.collect.Lists;
import net.yanrc.app.common.result.AbsentResult;
import net.yanrc.app.common.result.PresentResult;
import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.activity.biz.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.activity.biz.manger.ConfigPropertityManager;
import net.yanrc.xpring.activity.biz.model.ConfigModifyHistoryModel;
import net.yanrc.xpring.activity.biz.model.ConfigPropertityModel;
import net.yanrc.xpring.activity.biz.service.ConfigPropertityService;
import net.yanrc.xpring.activity.domain.ConfigPropertity;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
public class ConfigPropertityServiceImpl implements ConfigPropertityService {
    @Autowired
    private ConfigPropertityManager configPropertityManager;

    @Override
    public Result<List<ConfigPropertityModel>> queryList(ConfigPropertityQueryDto dto) {
        List<ConfigPropertity> configPropertityList = configPropertityManager.selectList(dto);
        if(CollectionUtils.isEmpty(configPropertityList)){
            return AbsentResult.absent();
        }

        List<ConfigPropertityModel> configPropertityModelList = Lists.newArrayListWithExpectedSize(configPropertityList.size());
        for(ConfigPropertity configPropertity:configPropertityList){
            ConfigModifyHistoryModel configModifyHistoryModel = new ConfigModifyHistoryModel();
            org.springframework.beans.BeanUtils.copyProperties(configPropertity,configModifyHistoryModel);
        }
        return PresentResult.fromNullable(configPropertityModelList);
    }
}
