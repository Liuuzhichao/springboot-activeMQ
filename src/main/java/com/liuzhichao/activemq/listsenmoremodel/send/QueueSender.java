package com.liuzhichao.activemq.listsenmoremodel.send;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
* @author 刘志超
* @date 2019-04-17 下午2:26:03
* @version 
* 类说明   queue模式发送消息端
*/
@Component
public class QueueSender {

	@Autowired
    JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue1;

    @Autowired
    private Queue queue2;

    /**
     * 发送一条消息到指定的队列
     * @param message 消息内容
     */
    public void send1(String message){
//    	message = "QUEUE1 send data";
        this.jmsTemplate.convertAndSend(queue1, message);
    }

    /**
     * 发送一条消息到指定的队列
     * @param message 消息内容
     */
    public void send2(String message){
//    	message = "QUEUE2 send data";
        this.jmsTemplate.convertAndSend(queue2, message);
    }
    
}
