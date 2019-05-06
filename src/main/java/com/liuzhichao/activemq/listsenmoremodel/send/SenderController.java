package com.liuzhichao.activemq.listsenmoremodel.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author 刘志超
* @date 2019-04-17 下午3:08:40
* @version 
* 类说明   测试类
*/
@RestController
@RequestMapping("/api")
public class SenderController {

	@Autowired
	private QueueSender queue;
	
	@Autowired
	private TopicSender topic;
	
	@RequestMapping("/send/queue")
	public void sendQueue() {
		queue.send1("QUEUE1 send data");
		queue.send2("QUEUE2 send data");
		System.out.println("queue send over");
	}
	
	@RequestMapping("/send/topic")
	public void sendtTopic() {
		topic.send1("TOPIC1 send data");
		topic.send2("TOPIC2 send data");
		System.out.println("send success");
	}
	
}
