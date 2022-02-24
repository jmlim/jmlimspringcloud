package io.jmlim.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

    //   @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // first-service 가 호출될 경우 아래 uri 정보로 호출된다. (yml 파일에 등록된 내용과 같은 내용)
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-response", "first-response-header"))
                        .uri("http://127.0.0.1:8081/")) // 헤더값을 추가하는 필터가 끝난 후 해당 uri 이동할 수 있다.
                .route(r -> r.path("/second-service/**") // second-service 가 호출될 경우 아래 uri 정보로 호출된다.
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://127.0.0.1:8082"))
                .build();
    }
}
