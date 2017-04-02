package net.yanrc.xpring.activity.dal.mapper;

import java.util.List;

import net.yanrc.xpring.activity.common.utils.anots.Logable;
import net.yanrc.xpring.activity.domain.Activity;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeyNotSafe(String id);

    int insert(Activity record);

    int insertSelective(Activity record);

    @Logable(end = true)
    Activity selectByPrimaryKey(Integer id);

    List<Activity> selectAll();

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}