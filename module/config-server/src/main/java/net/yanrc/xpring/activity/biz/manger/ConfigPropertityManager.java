package net.yanrc.xpring.activity.biz.manger;

import net.yanrc.xpring.activity.biz.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.activity.domain.ConfigPropertity;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
public interface ConfigPropertityManager {
    List<ConfigPropertity> selectList(ConfigPropertityQueryDto dto);
}
