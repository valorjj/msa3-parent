package com.example.apigateway.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Value("${security.jwks_uri}")
    private String JWKS_URL;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(
                exchange -> exchange
                    // 유레카 서버에 대한 접근은 항상 허용
                    .pathMatchers("/eureka/**").permitAll()
                    .anyExchange().authenticated()
            )
            .oauth2ResourceServer(i -> i.jwt(j -> j.jwkSetUri(JWKS_URL)))
        ;
        return httpSecurity.build();
    }
}
