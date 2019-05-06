package com.liuzhichao.activemq.listsenmoremodel.jmsconfig;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**
 * @author 刘志超
 * @date 2019-04-17 下午2:22:50
 * @version 类说明 配置类，读配置文件
 */
@Configuration
public class JmsConfig {
	
	@Value("spring.activemq.broker-url")
	private String brokerURL;
	@Value("spring.activemq.user")
	private String userName;
	@Value("spring.activemq.password")
	private String password;
	@Value("edw.sdp.topic.topicName1")
	private String topicName1;
	@Value("edw.sdp.topic.topicName2")
	private String topicName2;
	@Value("edw.sdp.queue.queueName1")
	private String queueName1;
	@Value("edw.sdp.queue.queueName2")
	private String queueName2;

	@Bean
	public Topic topic1() {
		return new ActiveMQTopic(topicName1);
	}

	@Bean
	public Topic topic2() {
		return new ActiveMQTopic(topicName2);
	}

	@Bean
	public Queue queue1() {
		return new ActiveMQQueue("aaaaaaa");
	}

	@Bean
	public Queue queue2() {
		return new ActiveMQQueue(queueName2);
	}
	
	/**
	 * 连接工厂
	 * @return
	 */
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		factory.setUserName(userName);
		factory.setPassword(password);
		return factory;
	}

	/**
	 * topic模式的ListenerContainer
	 * 
	 * @return
	 */
	@Bean
	public JmsListenerContainerFactory<?> topicListenerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		ActiveMQConnectionFactory connectionFactor = new ActiveMQConnectionFactory();
//		connectionFactor.setBrokerURL("tcp://11.11.160.78:61616");
//		connectionFactor.setUserName("admin");
//		connectionFactor.setPassword("admin");
		factory.setPubSubDomain(true);
		factory.setConnectionFactory(activeMQConnectionFactory);
		
		return factory;
	}

	/**
	 * queue模式的ListenerContainer
	 * 
	 * @return
	 */
	@Bean
	public JmsListenerContainerFactory<?> queueListenerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		ActiveMQConnectionFactory connectionFactor = new ActiveMQConnectionFactory();
//		connectionFactor.setBrokerURL("tcp://11.11.160.78:61616");
//		connectionFactor.setUserName("admin");
//		connectionFactor.setPassword("admin");
		factory.setPubSubDomain(false);
		factory.setConnectionFactory(activeMQConnectionFactory);
		return factory;
	}

}
