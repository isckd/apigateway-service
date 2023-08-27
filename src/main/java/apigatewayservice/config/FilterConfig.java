package apigatewayservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    /**
     * application.yml 파일에서 routing 하는 것을 코드상에서 대체할 수 있음.
     * 사용하지는 않을 것이기 때문에 주석처리
     */
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/first-service/**")
//                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
//                                        .addResponseHeader("first-response", "first-response-header"))
//                        .uri("http://localhost:8081"))
//                .route(r -> r.path("/second-service/**")
//                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
//                                .addResponseHeader("second-response", "second-response-header"))
//                        .uri("http://localhost:8081"))
//                .build();
//    }
}
