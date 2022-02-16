package com.tukjax.cargo.boot;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@EnableAutoConfiguration
public class WebConfiguration {

/*    @Bean
    public RouterFunction<ServerResponse> hello(ServerRequest serverRequest1){
       return RouterFunctions.route()
                .GET("/test/**",serverRequest -> {
                    System.out.println("path："+serverRequest1.exchange().getRequest().getPath().pathWithinApplication().value());

                    return ServerResponse.ok().bodyValue("hello world");
                })
                .filter((serverRequest, handlerFunction) -> {
                    System.out.println("custom filter");

                    return handlerFunction.handle(serverRequest);
                })
                .build();

    }*/

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory){
        return args->{
            System.out.println( beanFactory.getBean("CglibEnhancedBean").getClass().getName());

            System.out.println( beanFactory.getBean("PlainComponentBean").getClass().getName());
        };
    }
}
