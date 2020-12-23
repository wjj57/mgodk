package com.mgodk.web.core.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName ServletContextUtil
 * @Description Servlet 上下文工具类
 * @Author WJJ
 * @Date 2020/12/22 17:13
 * @Version 1.0
 */
public class ServletContextUtil {
    /** Servlet 请求属性 */
    public static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /** 获取 请求 */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /** 获取 响应 */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /** 获取 会话 */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /** 获取 参数，以字符串形式返回 */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }


    /** 渲染字符串 到客户端 */
    public static void renderString(HttpServletResponse response, String msg) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Ajax异步请求 判断 */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1) {
            return true;
        }
        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1) {
            return true;
        }
        return false;
    }
}
