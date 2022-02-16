package com.tukjax.cargo.boot;

import com.tukjax.cargo.spring.bean.CglibEnhancedBean;
import com.tukjax.cargo.spring.bean.PlainComponentBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.tukjax.cargo.boot.dao")
//@ComponentScan("com.tukjax.cargo.spring.bean.*")
public class CargoDemoApplicaiton {


	public static void main(String[] args) {
		SpringApplication.run(CargoDemoApplicaiton.class, args);
	}

}
