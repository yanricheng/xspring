package net.yanrc.xpring.activity.dal.mapper;

import net.yanrc.xpring.activity.domain.Participantor;

public interface ParticipantorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Participantor record);

    int insertSelective(Participantor record);

    Participantor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Participantor record);

    int updateByPrimaryKey(Participantor record);
}