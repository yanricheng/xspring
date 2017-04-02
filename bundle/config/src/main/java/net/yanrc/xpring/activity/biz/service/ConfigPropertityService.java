package net.yanrc.xpring.activity.biz.service;

import net.yanrc.app.common.result.Result;
import net.yanrc.xpring.activity.biz.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.activity.biz.model.ConfigPropertityModel;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
public interface ConfigPropertityService {
    Result<List<ConfigPropertityModel>> queryList(ConfigPropertityQueryDto dto);
}
