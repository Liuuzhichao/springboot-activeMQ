package com.liuzhichao.activemq.listenonemodel;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘志超
 * @date 2019-04-16 下午2:29:53
 * @version 类说明 发送消息
 */
@Component
@RestController
@RequestMapping("/api")
public class ActiveMqClient {

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping("/send/queue")
	public void send() {
		/**
		 * 此处设置只会影响发送消息的方式,可以设置为发送queue或者topic模式
		 * 但是并不会影响监听的模式
		 * true:topic;false:queue;不设置默认false
		 */
//		jmsTemplate.setPubSubDomain(false);
		for( int i = 0; i < 10; i++ ) {
			// send()方法的第一个参数,与接收端的destination的值相对应
			jmsTemplate.send("liuzhichaoQueue", new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMessage = session.createTextMessage();
					System.out.println("Queue发送数据.......");
					textMessage.setText("send queue data");
					return textMessage;
				}
			});
		}
	}
	
	@RequestMapping("/send/topic")
	public void sendTopic() {
//		jmsTemplate.setPubSubDomain(true);
		for( int i = 0; i < 10; i++ ) {
			// send()方法的第一个参数,与接收端的destination的值相对应
			jmsTemplate.send("liuzhichaoTopic", new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMessage = session.createTextMessage();
					System.out.println("Topic发送数据.......");
					textMessage.setText("send topic data");
					return textMessage;
				}
			});
		}
	}
	
}