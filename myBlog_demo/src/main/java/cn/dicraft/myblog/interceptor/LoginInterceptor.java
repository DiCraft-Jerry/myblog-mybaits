package cn.dicraft.myblog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承HandlerInterceptor适配器，重写预处理方法preHandle
 * 对session进行判断，看是否有用户，没有的话重定向到登录页面，给拦截掉
 * 还需要指定拦截的内容
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 14:23
 * @package: cn.dicraft.myblog.interceptor
 * @Version: 1.0
 * @Decsription: 登录过滤拦截
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //判断session里面是否有用户，没有的话重定向到登录页面，给拦截掉
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
