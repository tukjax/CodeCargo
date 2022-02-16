package com.tukjax.cargo.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CglibEnhancedBean {



    @Bean
    public  CglibEnhancedBean cglibEnhancedBean(){
        return new CglibEnhancedBean();
    }
}
