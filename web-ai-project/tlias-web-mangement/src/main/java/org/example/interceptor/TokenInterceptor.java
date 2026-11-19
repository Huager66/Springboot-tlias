package org.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS"))
            return true;

        // 1. 获取请求路径
        String requestURI = request.getRequestURI();

        // 2. 登录请求直接放行
        if (requestURI.contains("/login")) {
            log.info("登录请求，放行");
            return true;
        }

        // 3. 获取请求头中的令牌
        String token = request.getHeader("token");
        log.info("请求头 token = {}", token);

        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //5. 令牌存在则校验，校验失败返回 401
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401。token={}, 异常类型={}, 原因={}",
                    token, e.getClass().getSimpleName(), e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        log.info("令牌校验通过");
        return true;
    }
}