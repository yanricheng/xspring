package net.yanrc.xpring.activity.dal.mapper;

import net.yanrc.xpring.activity.biz.dto.query.ConfigPropertityQueryDto;
import net.yanrc.xpring.activity.domain.ConfigPropertity;

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