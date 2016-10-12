package net.yanrc.xpring.web.biz;

import net.yanrc.xpring.rpc.dto.query.UserQueryDto;
import net.yanrc.xpring.rpc.model.UserModel;

/**
 * UserModel 本地接口
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:15
 */
public interface UserBizService {
    boolean save(UserQueryDto userQueryDto);

    UserModel getById(Integer id);

    UserModel add();

    boolean removeById(Integer id);

    boolean edit(UserModel user);


}