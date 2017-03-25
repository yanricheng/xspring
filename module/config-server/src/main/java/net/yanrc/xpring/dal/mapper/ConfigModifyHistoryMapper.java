package net.yanrc.xpring.dal.mapper;

import net.yanrc.xpring.dal.domain.ConfigModifyHistory;

public interface ConfigModifyHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfigModifyHistory record);

    int insertSelective(ConfigModifyHistory record);

    ConfigModifyHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigModifyHistory record);

    int updateByPrimaryKeyWithBLOBs(ConfigModifyHistory record);

    int updateByPrimaryKey(ConfigModifyHistory record);
}