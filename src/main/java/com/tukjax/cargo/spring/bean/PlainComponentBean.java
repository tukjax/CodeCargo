package com.tukjax.cargo.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PlainComponentBean {

    @Bean
    public  PlainComponentBean plainComponentBean(){
        return new PlainComponentBean();
    }
}
