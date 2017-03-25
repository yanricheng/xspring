package net.yanrc.xpring.dal.mapper;

import net.yanrc.xpring.dal.domain.ConfigPropertity;
import net.yanrc.xpring.rpc.dto.query.ConfigPropertityQueryDto;

import java.util.List;

public interface ConfigPropertityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfigPropertity record);

    int insertSelective(ConfigPropertity record);

    ConfigPropertity selectByPrimaryKey(Long id);

    List<ConfigPropertity> selectList(ConfigPropertityQueryDto dto);

    int updateByPrimaryKeySelective(ConfigPropertity record);

    int updateByPrimaryKeyWithBLOBs(ConfigPropertity record);

    int updateByPrimaryKey(ConfigPropertity record);
}