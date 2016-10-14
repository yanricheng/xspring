package net.yanrc.xpring.rpc.utils;

/**
 * Created by yanricheng on 16-10-14.
 */
public class Caches {

    public static final byte[] PREFIX = "_:".getBytes();

    public static byte[] getCachePrefix() {
        return PREFIX;
    }
}
