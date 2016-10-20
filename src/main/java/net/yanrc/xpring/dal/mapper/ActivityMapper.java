package net.yanrc.xpring.dal.mapper;

import net.yanrc.xpring.dal.entity.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    List<Activity> selectAll();

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}