package net.yanrc.xpring.rpc.manger;

import net.yanrc.xpring.dal.entity.ConfigPropertity;
import net.yanrc.xpring.rpc.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.rpc.model.ConfigPropertityModel;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
public interface ConfigPropertityManager {
    List<ConfigPropertity> selectList(ConfigPropertityQueryDto dto);
}
