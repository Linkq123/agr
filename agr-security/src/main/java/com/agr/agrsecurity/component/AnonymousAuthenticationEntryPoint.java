package com.agr.agrsecurity.component;

import com.agr.agrsecurity.util.ServletUtils;
import com.agr.agrsecurity.entry.ResponseCode;
import com.agr.agrsecurity.entry.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Slf4j
@Component
public class AnonymousAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.warn("用户需要登录，访问[{}]失败，AuthenticationException={}", request.getRequestURI(), e);
        ServletUtils.render(request, response, RestResponse.failCode(ResponseCode.USER_NEED_LOGIN));
    }
}
