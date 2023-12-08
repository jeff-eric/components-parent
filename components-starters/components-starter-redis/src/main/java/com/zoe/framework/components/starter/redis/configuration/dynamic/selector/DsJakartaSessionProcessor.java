//package com.zoe.framework.components.starter.redis.configuration.dynamic.selector;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//public class DsJakartaSessionProcessor extends DsSelector {
//
//    /**
//     * session开头
//     */
//    private static final String SESSION_PREFIX = "#session";
//
//    @Override
//    public boolean matches(String key) {
//        return key.startsWith(SESSION_PREFIX);
//    }
//
//    @Override
//    public String doDetermineConnectionFactory(MethodInvocation invocation, String key) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        return request.getSession().getAttribute(key.substring(9)).toString();
//    }
//}