package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // 在请求被路由之前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定，优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println("--->>> TokenFilter " + request.getMethod() + ", "
                + request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess", true);
            return null;
        } else {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("Token is empty.");
            requestContext.set("isSuccess", false);
            return null;
        }
    }

}
