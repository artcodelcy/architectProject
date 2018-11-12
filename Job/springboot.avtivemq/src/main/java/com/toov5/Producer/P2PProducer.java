package com.toov5.Producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class P2PProducer {
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
	//把队列注入进来 
	@Autowired  //此注解默认是以类型找  在配置文件中 已经注入的  @Bean 
	private Queue queue;
	
	//每隔5s时间向队列发送消息
	@Scheduled(fixedDelay=5000)  //每间隔2s向队列发送消息
	public void send() {
		String userName = System.currentTimeMillis()+" ";
	        JSONObject jsonObject  = new JSONObject();
		    jsonObject.put("username", userName);
		    jsonObject.put("email", "acmtest@163.com");
		    String msgString = jsonObject.toJSONString();
	     	jmsMessagingTemplate.convertAndSend(queue,msgString);
		System.out.println("点对点通讯，msg"+msgString);
	}
}
