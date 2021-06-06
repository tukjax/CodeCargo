package com.tukjax.cargo.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tukjax.cargo.tukjaxTheCoder.dao.*")
public class TukjaxTheCoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TukjaxTheCoderApplication.class, args);
	}

}
