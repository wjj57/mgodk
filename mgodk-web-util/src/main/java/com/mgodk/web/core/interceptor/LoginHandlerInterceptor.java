package com.mgodk.web.core.interceptor;

import com.mgodk.api.pojo.SysUser;
import com.mgodk.web.core.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @ClassName LoginHandlerInterceptor
 * @Description 登录拦截器
 * @Author WJJ
 * @Date 2020/10/29 10:41
 * @Version 1.0
 */
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginHandlerInterceptor =》 preHandle - 在请求处理之前调用，即在Controller方法调用之前");
        SysUser user = (SysUser) request.getSession().getAttribute(Constant.SESSION_USER_INFO);
        if (Objects.isNull(user)) {
            request.setAttribute("msg","Session 不存在");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        if ("user".equals(user.getLoginName())) {
            request.setAttribute("msg","没有访问权限");
            request.getRequestDispatcher("/login").forward(request,response);
//            response.sendRedirect("/error");
//            request.getRequestDispatcher("/error").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LoginHandlerInterceptor =》 postHandle - 在请求处理之后调用，即在controller方法执行之后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LoginHandlerInterceptor =》 afterCompletion - 在整个请求之后调用，即在dispatcherServlet渲染了对应的视图之后（主要是进行资源清理工作）");
    }
}
