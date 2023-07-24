package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登录成功之后，应该有用户的session；
        Object loginUser = request.getSession().getAttribute("loginUser");
        Object loginDoc = request.getSession().getAttribute("loginDoc");

        if (loginUser == null && loginDoc == null) {
            // 若未登录，将请求转发到登录页面
            request.setAttribute("msg", "您还未登录，请先登录");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        } else {
            // 用户已登录且用户类型合法，允许其继续访问
            return true;
        }


    }


}
