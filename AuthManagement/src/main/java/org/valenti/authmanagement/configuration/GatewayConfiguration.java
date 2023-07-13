package org.valenti.authmanagement.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-management", r -> r.path("/user/**")
                        .uri("http://localhost:8080"))
                .route("friendship-management", r -> r.path("/friendship/**")
                        .uri("http://localhost:8082"))
                .route("shared-payment-management", r -> r.path("/shared_payment/**")
                        .uri("http://localhost:8083"))
                .route("balance-management", r -> r.path("/balance/**")
                        .uri("http://localhost:8084"))
                .build();
    }
}
