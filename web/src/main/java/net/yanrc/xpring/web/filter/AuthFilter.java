package net.yanrc.xpring.web.filter;

import net.yanrc.xpring.common.utils.config.ConfigUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by yanricheng on 16-11-16.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//        System.out.println("sid:" + session.getId());
//        if (session.getAttribute("name") == null) {
//            System.out.println("put name....");
//            session.setAttribute("name", "yanrc");
//        } else {
//            System.out.println("get name:" + session.getAttribute("name").toString());
//        }

        System.out.println(ConfigUtils.getDynamicPropertyFactory().getStringProperty("user.name","yanrc").get());

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
