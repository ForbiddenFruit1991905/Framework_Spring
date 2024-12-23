package ru.example.task3.stuff;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Start time: " + System.currentTimeMillis());
        // Продолжить выполнение цепочки перехватчиков и обработку запроса
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        System.out.println("End time: " + System.currentTimeMillis());
        System.out.println("=========================================");
    }
}
