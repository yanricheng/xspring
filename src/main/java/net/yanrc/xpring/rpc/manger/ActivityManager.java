package net.yanrc.xpring.rpc.manger;

import net.yanrc.xpring.common.utils.anots.Logable;
import net.yanrc.xpring.dal.entity.Activity;

import java.util.List;

/**
 * Created by yanricheng on 16-10-13.
 */
public interface ActivityManager {

    Activity add(Activity activity);

    Activity addSelective(Activity activity);

    boolean remove(Integer id);

    Activity editById(Activity activity);

    Activity editByIdSelective(Activity activity);

    Activity getById(Integer id);

    @Logable()
    Activity getActById(Integer id);

    List<Activity> getAll();
}
