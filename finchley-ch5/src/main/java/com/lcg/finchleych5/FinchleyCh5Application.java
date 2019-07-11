package com.lcg.finchleych5;

import com.lcg.finchleych5.filter.RequestTimeFilter;
import com.lcg.finchleych5.filter.TokenFilter;
import com.lcg.finchleych5.keyResolver.HostAddrKeyResolver;
import com.lcg.finchleych5.keyResolver.UriKeyResolver;
import com.lcg.finchleych5.keyResolver.UserKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinchleyCh5Application {

    public static void main(String[] args) {
        SpringApplication.run(FinchleyCh5Application.class, args);
    }

    /**
     * GateWay Filter
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }

    /**
     * Global Filter
     * @return
     */
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    /**
     * GateWay HostName限流
     * @return
     */
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver(){
        return new HostAddrKeyResolver();
    }

    /**
     * GateWay Uri限流
     */
    @Bean
    public UriKeyResolver uriKeyResolver(){
        return new UriKeyResolver();
    }

    /**
     * GateWay User限流
     */
    @Bean
    public UserKeyResolver userKeyResolver(){
        return new UserKeyResolver();
    }
}
