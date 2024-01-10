package com.agr.agrsecurity.component;

import com.agr.agrsecurity.util.ServletUtils;
import com.agr.agrsecurity.entry.RestResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {

        // TODO 登录成功 记录日志
        ServletUtils.render(request, response, RestResponse.success(authentication));
    }
}
