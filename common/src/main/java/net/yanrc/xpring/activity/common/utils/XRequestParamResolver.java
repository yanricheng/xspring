package net.yanrc.xpring.activity.common.utils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;

/**
 * Created by hzyanricheng on 16-3-17.
 */
public class XRequestParamResolver extends RequestParamMethodArgumentResolver {

    public XRequestParamResolver() {
        super(true);
    }

    public XRequestParamResolver(boolean useDefaultResolution) {
        super(useDefaultResolution);
    }

    public XRequestParamResolver(ConfigurableBeanFactory beanFactory, boolean useDefaultResolution) {
        super(beanFactory, useDefaultResolution);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(XRequestParam.class);
    }

    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest webRequest) throws Exception {
        Object obj = super.resolveName(name, parameter, webRequest);

        XRequestParam xRequestParam = parameter.getParameterAnnotation(XRequestParam.class);
        String fieldName = xRequestParam.name();
        if (xRequestParam.required()) {
            if (Objects.isEmpty(obj)) {
                throw new IllegalArgumentException(String.format("%s 不能为空!", fieldName));
            } else {
                int maxLen = xRequestParam.maxLen();
                int minLen = xRequestParam.minLen();
                int len = Objects.getLength(obj);

                if (len < minLen || len > maxLen) {
                    throw new IllegalArgumentException(String.format("%s 长度应该在：%s - %s 不能为空!", fieldName, minLen, maxLen));
                }
            }
        }

        //TODO XSS

        return obj;
    }
}
