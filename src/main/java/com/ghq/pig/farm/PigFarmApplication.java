package com.ghq.pig.farm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ghq.pig.farm.**.mapper")
@EnableSwagger2
public class PigFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigFarmApplication.class, args);
	}

}
