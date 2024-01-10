package com.agr.agrsecurity.component;

import com.agr.agrsecurity.entry.ResponseCode;
import com.agr.agrsecurity.util.ServletUtils;
import com.agr.agrsecurity.entry.RestResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class LoginUserAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ServletUtils.render(request, response, RestResponse.build(ResponseCode.NO_AUTHENTICATION));
    }
}
