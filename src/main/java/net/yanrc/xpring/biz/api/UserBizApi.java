package net.yanrc.xpring.biz.api;

import net.yanrc.xpring.data.dto.UserQueryDto;
import net.yanrc.xpring.data.model.User;

/**
 * User 本地接口
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:15
 */
public interface UserBizApi {
    boolean save(UserQueryDto userQueryDto);

    User getById(Integer id);

    User add();

    boolean removeById(Integer id);

    boolean edit(User user);


}