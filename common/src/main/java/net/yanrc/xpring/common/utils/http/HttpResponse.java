package net.yanrc.xpring.common.utils.http;

import net.yanrc.app.common.util.JsonUtils;

/**
 * Created by yanricheng on 16-8-20.
 */
public class HttpResponse {
    boolean succeed;
    int resCode;
    String resBody;

    public HttpResponse(boolean succeed, int resCode, String resBody) {
        this.succeed = succeed;
        this.resCode = resCode;
        this.resBody = resBody;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResBody() {
        return resBody;
    }

    public void setResBody(String resBody) {
        this.resBody = resBody;
    }

    @Override
    public String toString() {
        return JsonUtils.fromObject(this);
    }
}