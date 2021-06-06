package com.tukjax.cargo.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tukjax.cargo.tukjaxTheCoder.dao.*")
public class CargoDemoApplicaiton {

	public static void main(String[] args) {
		SpringApplication.run(CargoDemoApplicaiton.class, args);
	}

}
