package com.pikcurchu.pikcur;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pikcurchu.pikcur.mapper")
public class PikcurApplication {

	public static void main(String[] args) {
		SpringApplication.run(PikcurApplication.class, args);
	}

}
