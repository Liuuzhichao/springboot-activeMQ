package com.liuzhichao.activemq.listsenonemodel1;


import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
* @author 刘志超
* @date 2019-04-16 下午2:29:32
* @version 
* 类说明   
*/
@Configuration
public class ActiveTopicConfig {

	@Bean
    public Topic topic(){
		//参数为通信的目的地名字
        return new ActiveMQTopic("topic");
    }
    
}
