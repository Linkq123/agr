package com.agr.agrsecurity.component;

import com.agr.agrsecurity.entry.ResponseCode;
import com.agr.agrsecurity.util.ServletUtils;
import com.agr.agrsecurity.entry.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Slf4j
@Component
public class InvalidSessionHandler  implements InvalidSessionStrategy {

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.warn("用户登录超时，访问[{}]失败",request);
        ServletUtils.render(request, response, RestResponse.failCode(ResponseCode.USER_LOGIN_TIMEOUT));
    }
}
