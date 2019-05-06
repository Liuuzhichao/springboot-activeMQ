package com.liuzhichao.activemq.listsenonemodel1;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author 刘志超
* @date 2019-04-16 下午3:14:34
* @version 
* 类说明   
*/
@Configuration
public class ActiveQueueConfig {

	@Bean
    public Queue queue(){
		//参数为通信的目的地名字
        return new ActiveMQQueue("queue");
    }
}
