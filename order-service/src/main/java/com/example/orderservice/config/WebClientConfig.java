package com.example.orderservice.config;

import com.example.orderservice.client.InventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    // private final LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction;
    // 아래는 LoadBalancedExchangeFilterFunction 의 구현체이다.
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    /**
     * [LoadBalancer 을 사용해야하는 이유?]
     * Eureka Server 에 서비스가 다수 등록되는 경우,
     * 서비스 인스턴스들이 생성과 파괴를 반복해서 겪게 된다. (쿠버네티스도 동일)
     * 따라서 서비스 인스턴스 간 통신을 위해서 health check 를 지속적으로 하며,
     * 내부 ip 를 추적해서 교통정리를 도와줄 존재가 필요하다. 이를 로드 밸런서(=부하 분산기) 라고 한다.
     *
     * */
    @Bean
    @LoadBalanced
    public WebClient inventoryWebClient() {
        return WebClient.builder()
            .filter(lbFunction)
            .baseUrl("http://localhost:8082")
            .build();
    }

    @Bean
    public InventoryClient inventoryClient() {
        HttpServiceProxyFactory proxyFactory
            = HttpServiceProxyFactory.builder(
                WebClientAdapter.forClient(inventoryWebClient())
            )
            .build();
        return proxyFactory.createClient(InventoryClient.class);
    }

}
