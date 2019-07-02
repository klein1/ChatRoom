package com.manage.web.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/6.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        boolean flag = false;

        HttpSession session = request.getSession();

        List<String> allowUrls = new ArrayList<String>();
        allowUrls.add("login");
        String url = request.getRequestURL().toString();

        for (String item :
                allowUrls) {
            if (url.contains(item))
                flag = true;
        }

        String mobile = (String) session.getAttribute("adminNo");
        if (mobile != null)
            flag = true;

        if (!flag){
            response.sendRedirect("/admin/login.htm");
        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {

    }
}