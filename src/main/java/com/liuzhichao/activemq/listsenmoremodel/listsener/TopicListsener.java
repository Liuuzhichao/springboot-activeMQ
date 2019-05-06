package com.liuzhichao.activemq.listsenmoremodel.listsener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘志超
 * @date 2019-04-17 下午2:35:45
 * @version 类说明 topic模式的监听类
 */
@Component
public class TopicListsener {

	/**
	 * 如果多个消费者同时消费1个队列，QueueReceiver写多个
	 * 注解中的参数不能读配置文件，监听就写死
	 */
	@JmsListener(destination = "test", containerFactory = "topicListenerFactory")
	public void receiveTopic1(String text) {
		System.out.println("监听topic1" + text);
	}

	@JmsListener(destination = "test", containerFactory = "topicListenerFactory")
	public void receiveTopic2(String text) {
		System.out.println("监听topic2" + text);
	}

}
