package com.damine.apigateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    @Autowired
    private RouteValidator routeValidator;
    @Autowired
    private RestTemplate restTemplate;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }
                String authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeaders != null && authHeaders.startsWith("Bearer ")) {
                    authHeaders = authHeaders.substring(7);
                    System.out.println(authHeaders+"***********************************");
                }
                try {
                    restTemplate.getForObject("http://localhost:8082/auth/validate?token=" + authHeaders, String.class);
                } catch (Exception e) {
                    throw new RuntimeException("unauthorized access to application");
                }
            }
            return chain.filter(exchange);
        }));
    }
    public static class Config {
    }
}


