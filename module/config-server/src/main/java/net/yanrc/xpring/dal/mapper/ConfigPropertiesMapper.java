package net.yanrc.xpring.dal.mapper;

import net.yanrc.xpring.dal.entity.ConfigProperties;

import java.util.List;

public interface ConfigPropertiesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfigProperties record);

    int insertSelective(ConfigProperties record);

    ConfigProperties selectByPrimaryKey(Long id);

    List<ConfigProperties> selectAll();

    int updateByPrimaryKeySelective(ConfigProperties record);

    int updateByPrimaryKeyWithBLOBs(ConfigProperties record);

    int updateByPrimaryKey(ConfigProperties record);
}