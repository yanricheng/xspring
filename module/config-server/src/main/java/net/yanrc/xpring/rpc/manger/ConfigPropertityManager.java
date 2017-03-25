package net.yanrc.xpring.rpc.manger;

import net.yanrc.xpring.dal.domain.ConfigPropertity;
import net.yanrc.xpring.rpc.dto.query.ConfigPropertityQueryDto;

import java.util.List;

/**
 * Created by yanricheng on 16-11-30.
 */
public interface ConfigPropertityManager {
    List<ConfigPropertity> selectList(ConfigPropertityQueryDto dto);
}
