package com.liuzhichao.activemq.listsenmoremodel.send;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
* @author 刘志超
* @date 2019-04-17 下午2:28:22
* @version 
* 类说明   topic模式发送端
*/
@Component
public class TopicSender {

	@Autowired
    JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Topic topic1;

    @Autowired
    private Topic topic2;

    /**
     * 发送一条消息到指定的主题
     * @param message 消息内容
     */
    public void send1(String message){
//    	message = "TOPIC1 send data";
        this.jmsTemplate.convertAndSend(topic1, message);
    }

    /**
     * 发送一条消息到指定的主题
     * @param message 消息内容
     */
    public void send2(String message){
//    	message = "TOPIC2 send data";
        this.jmsTemplate.convertAndSend(topic2, message);
    }

}
