package com.liuzhichao.activemq.listsenmoremodel.listsener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘志超
 * @date 2019-04-17 下午2:30:55
 * @version 类说明 queue模式的监听类
 */
@Component
public class QueueListsener {

	/**
	 * 如果多个消费者同时消费1个队列，QueueReceiver写多个
	 * 注解中的参数不能读配置文件，监听就写死
	 */
	@JmsListener(destination = "aaaaaaa", containerFactory = "queueListenerFactory")
	public void receiveQueue1(String text) {
		System.out.println("监听消息queue1:" + text);
	}

	@JmsListener(destination = "test", containerFactory = "queueListenerFactory")
	public void receiveQueue2(String text) {
		System.out.println("监听消息queue2:" + text);
	}

}
