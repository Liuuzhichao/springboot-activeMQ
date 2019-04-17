package com.liuzhichao.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class ActiveMqListsenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqListsenerApplication.class, args);
	}

}
