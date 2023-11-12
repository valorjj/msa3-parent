package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder rlb) {
        return rlb.routes()
            .route("productService", r -> r.path("/api/v1/product").uri("lb://product-service"))
            .route("orderService", r -> r.path("/api/v1/order")
                // circuit breaker implementation on the classpath that supports reactive APIs.
                // 위 에러 발생
                // .filters(f -> f.circuitBreaker(c -> c.setName("fallback").setFallbackUri("forward:/fallback")))
                .uri("lb://order-service"))
            .route("inventoryService", r -> r.path("/api/v2/inventory").uri("lb://inventory-service"))
            .route("discoveryServer", r -> r.path("/eureka/web").filters(i -> i.setPath("/")).uri("http://eureka:password@localhost:8761/eureka"))
            .route("discoveryStaticResources", r -> r.path("/eureka/**").uri("http://eureka:password@localhost:8761/eureka"))
            .build();

    }


}
