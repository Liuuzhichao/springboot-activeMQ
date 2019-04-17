package com.liuzhichao.activemq.listenonemodel;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
* @author 刘志超
* @date 2019-04-16 下午2:29:53
* @version 
* 类说明   监听接收消息
*/
@Component
public class ActiveMqServer {
	
	/**
	 * 利用注解自动进行监听
	 * destination:对应发送消息的send方法的第一个参数,为创建出的queue或者topic的名字
	 * 监听的模式会读取配置文件中配置的spring.jms.pub-sub-domain=?的属性
	 * true:topic模式;false:queue;不配置默认false
	 * 只会对一种模式进行监听,可以监听一种模式的多个消息
	 * @param message
	 */
	@JmsListener(destination = "topic")
    public void receiveTopic(String message) {
        System.out.println("监听topic=============监听topic");
        System.out.println(message);
    }

    @JmsListener(destination = "liuzhichaoQueue")
    public void receiveQueue(String message) {
        System.out.println("监听queue=============监听queue");
        System.out.println(message);
    }
    
    @JmsListener(destination = "liuzhichaoTopic")
    public void receiveLiuzhichao(String message) {
        System.out.println("监听liuzhichao=============监听liuzhichao");
        System.out.println(message);
    }
    
    @JmsListener(destination = "liuzhichaoTopic")
    public void receiveLiu(String message) {
        System.out.println("监听liu=============监听liu");
        System.out.println(message);
    }
    
}
