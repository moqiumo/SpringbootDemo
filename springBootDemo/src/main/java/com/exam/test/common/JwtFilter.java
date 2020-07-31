package com.exam.test.common;

import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * JWT过滤器，拦截 /secure的请求
 */
@Slf4j
@WebFilter(filterName = "JwtFilter",urlPatterns = {"/user/a/*","/person/*"})
public class JwtFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request=(HttpServletRequest)servletRequest;
        final HttpServletResponse response=(HttpServletResponse)servletResponse;

        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String tokens=request.getHeader("authorization");
        String[] tokenString;
        String token = null;
        if(tokens != null){ 
            tokenString = tokens.split(" ");
            token = tokenString[1];
        }
 
        System.out.println("token:"+token);
        if ("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
        }
        else {//Except OPTIONS, other request should be checked by JWT
            if(token==null){
                response.getWriter().write("没有token!");
                return;
            }
            Map<String, Claim> userData= JwtUtil.verifyToken(token);
            if (userData==null){
                response.getWriter().write("token不合法！");
                return;
            }
            Integer id=userData.get("id").asInt();
            String username=userData.get("username").asString();
            String password=userData.get("password").asString();
            //拦截器，拿到用户信息，并且放入request中
            request.setAttribute("id",id);
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
