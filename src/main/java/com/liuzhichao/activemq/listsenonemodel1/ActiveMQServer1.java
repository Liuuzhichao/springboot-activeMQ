package com.liuzhichao.activemq.listsenonemodel1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
* @author 刘志超
* @date 2019-04-17 下午2:07:17
* @version 
* 类说明   接收消息端
*/
@Component
public class ActiveMQServer1 {

	@JmsListener(destination = "topic")
    public void receiveTopic(String message) {
        System.out.println("监听topic=============监听topic");
        System.out.println(message);

    }

    @JmsListener(destination = "queue")
    public void receiveQueue(String message) {
        System.out.println("监听queue=============监听queue");
        System.out.println(message);

    }
}
