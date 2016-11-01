package net.yanrc.xpring.common.utils.http;

import com.fasterxml.jackson.databind.JavaType;
import net.yanrc.app.common.util.JsonUtils;

import java.util.TreeMap;

/**
 * Created by yanricheng on 16-8-20.
 */
public class SimpleHttpRequest {
    private String url;
    private HttpRequestType type = HttpRequestType.GET;
    private TreeMap parameterMap = HttpUtils.createCommonParameter();
    private Integer readTimeout = HttpUtils.DEFAULT_READ_TIMEOUT;
    private Integer connectTimeout = HttpUtils.DEFAULT_CONNECT_TIMEOUT;

    public  static SimpleHttpRequest newInstance(){
        return new SimpleHttpRequest();
    }

    public SimpleHttpRequest readTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public SimpleHttpRequest connectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public SimpleHttpRequest reqUrl(String url) {
        this.url = url;
        return this;
    }

    public SimpleHttpRequest reqType(HttpRequestType type) {
        this.type = type;
        return this;
    }

    public SimpleHttpRequest addParameter(String key, String value) {
        parameterMap.put(key, value);
        return this;
    }

    public HttpResponse execute() {
        return HttpUtils.send(url, type, connectTimeout, readTimeout, parameterMap);
    }

    public <T> T execute(Class<T> tClass) {
        HttpResponse httpResponse = HttpUtils.send(url, type, connectTimeout, readTimeout, parameterMap);
        if (httpResponse.isSucceed()) {
            return JsonUtils.toBean(httpResponse.getResBody(), tClass);
        }
        return null;
    }

    public <T> T execute(JavaType javaType) {
        HttpResponse httpResponse = HttpUtils.send(url, type, connectTimeout, readTimeout, parameterMap);
        if (httpResponse.isSucceed()) {
            return JsonUtils.toBean(httpResponse.getResBody(), javaType);
        }
        return null;
    }

    @Override
    public String toString() {
        return JsonUtils.fromObject(this);
    }
}
