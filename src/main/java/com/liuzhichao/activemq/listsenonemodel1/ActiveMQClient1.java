package com.liuzhichao.activemq.listsenonemodel1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author 刘志超
 * @date 2019-04-16 下午2:30:05
 * @version 类说明 发送消息端
 */
@RestController
@RequestMapping("/api")
public class ActiveMQClient1 {

	@Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Topic topic;

    @Autowired
    private Queue queue;

    @RequestMapping("/send")
    public void send(){
        jmsTemplate.convertAndSend(this.topic,"发送的topic数据!");
        jmsTemplate.convertAndSend(this.queue,"发送的queue数据!");
    }

}
