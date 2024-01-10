package com.agr.agrsecurity.component;

import com.agr.agrsecurity.util.ServletUtils;
import com.agr.agrsecurity.entry.RestResponse;
import org.springframework.security.core.Authentication;
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
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler{

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // TODO 登出成功 记录登出日志
        ServletUtils.render(request, response, RestResponse.success());
    }
}
