package com.example.wenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WendaApplication.class, args);
	}
}
