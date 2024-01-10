package com.agr.agrsecurity.component;

import com.agr.agrsecurity.entry.ResponseCode;
import com.agr.agrsecurity.entry.RestResponse;
import com.agr.agrsecurity.util.ServletUtils;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Component
public class SessionInformationExpiredHandler  implements SessionInformationExpiredStrategy {


    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {

        ServletUtils.render(sessionInformationExpiredEvent.getRequest(),
                sessionInformationExpiredEvent.getResponse(), RestResponse.failCode(ResponseCode.USER_MAX_LOGIN));
    }
}
