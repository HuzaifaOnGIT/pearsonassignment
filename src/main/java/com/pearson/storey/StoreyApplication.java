package com.pearson.storey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class StoreyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreyApplication.class, args);
	}

}
