package apigatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;


/**
 * Global FIlter 는 모든 라우팅 경로에 실행된다.
 * Filter 실행순서는 아래와 같다.
 *  1. Global Pre Filter
 *  2. Custom Pre Filter
 *  3. Logging Filter
 *  4. Custom Post Filter
 *  5. Global Post Filter
 */
@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GlobalFilter.class);

    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // Global Pre Filter
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();  // reactive serverHttpRequest 로 작성해야 함.
            ServerHttpResponse response = exchange.getResponse();

            log.info("GLobal Filter baseMessage: {}", config.getBaseMessage());

            if(config.isPreLogger()) {
                log.info("Global Filter Start: request id -> {}", request.getId());
            }

            // Global Post Filter
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPostLogger()) {
                    log.info("Global Filter End: response id -> {}", response.getStatusCode());
                }
            }));

        });

    }

    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

        public String getBaseMessage() {
            return this.baseMessage;
        }

        public boolean isPreLogger() {
            return this.preLogger;
        }

        public boolean isPostLogger() {
            return this.postLogger;
        }

        public void setBaseMessage(String baseMessage) {
            this.baseMessage = baseMessage;
        }

        public void setPreLogger(boolean preLogger) {
            this.preLogger = preLogger;
        }

        public void setPostLogger(boolean postLogger) {
            this.postLogger = postLogger;
        }
    }
}