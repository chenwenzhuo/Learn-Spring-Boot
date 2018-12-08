package com.heythere.first_Spring_Boot_demo.config;

import com.heythere.first_Spring_Boot_demo.domain.User;
import com.heythere.first_Spring_Boot_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * 路由器函数 配置
 */
@Configuration
public class RouterFunctionConfiguration {
    /**
     * Servlet
     * 请求接口：ServletRequest 或 HttpServletRequest
     * 响应接口：ServletResponse 或 HttpServletResponse
     * Spring 5.0 重新定义了服务请求和响应接口：
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 既可以支持 Servlet 规范，也可以支持自定义，如 Netty(Web Server)
     * 以本例：
     * 定义 GET 请求，并且返回所有的用户对象 URI:/person/find/all
     * Flux是 0-n 个对象集合
     * Mono是 0-1 个对象集合
     * Reactive中的Flux或Mono是异步处理（非阻塞）
     * 集合对象基本是同步处理（阻塞）
     * Flux或Mono
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindALL(UserRepository userRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"), serverRequest -> {
            //返回所有用户对象
            Collection<User> users = userRepository.findAll();
            Mono<ServerResponse> response = null;
            Flux<User> userFlux = Flux.fromIterable(users);
            return ServerResponse.ok().body(userFlux, User.class);
        });
    }
}
