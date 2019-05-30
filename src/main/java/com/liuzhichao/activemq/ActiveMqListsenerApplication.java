package com.liuzhichao.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.liuzhichao.activemq")
public class ActiveMqListsenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqListsenerApplication.class, args);
	}

}
