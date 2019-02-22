package com.example.demo.interceptor;

import com.example.demo.entity.ResultMessage;
import com.example.demo.helper.JwtUtil;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class TestInterceptor implements HandlerInterceptor {

    //带有token的aip
    private final String[] tokenApiLists = {"/addOrder"};

    //验证token 的
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    ResultMessage resultMessage;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 这里写各种判断逻辑
        // 如果没有………………，可以使用 reponse.send() 跳转页面。后面要跟return false,否则无法结束;

        // 为了测试，打印一句话
        try {
            System.out.println(request.getRequestURI());
            System.out.println(request.getRequestURL().toString());
            System.out.println(request.getHeader("token"));
            System.out.println("访问了test下url路径。");
            String api = request.getRequestURI();
            if(this.isHasTokenApi(api)){
                String token = request.getHeader("token");
                Integer userId = jwtUtil.getUserId(token);
                String secret = userServiceImpl.getSecret();
                //是否是可用的token
                Boolean isOkToken = jwtUtil.verify(token,userId,secret);
                System.out.println("isOkToken"+isOkToken);
                if(isOkToken){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }catch (Exception e){
            System.out.println("eeeeeee"+e);
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
    //是否是必须携带token的api
    public Boolean isHasTokenApi(String url){
        return Arrays.asList(this.tokenApiLists).contains(url);
    }
}
