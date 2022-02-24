package io.jmlim.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {
    /**
     * 필터 타입 설정
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre"; // 사전필터
    }

    /**
     * 필터 순서
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 원하는 옵션에 따라 필터를 쓸지 말지 선택
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 로그, 인증정보 등을 여기서 출력 할 수 있다. 
        log.info("********************** printing logs: ");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("********************** {}", request.getRequestURI());
        return null;
    }
}
