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
	//�Ѷ���ע����� 
	@Autowired  //��ע��Ĭ������������  �������ļ��� �Ѿ�ע���  @Bean 
	private Queue queue;
	
	//ÿ��5sʱ������з�����Ϣ
	@Scheduled(fixedDelay=5000)  //ÿ���2s����з�����Ϣ
	public void send() {
		String userName = System.currentTimeMillis()+" ";
	        JSONObject jsonObject  = new JSONObject();
		    jsonObject.put("username", userName);
		    jsonObject.put("email", "acmtest@163.com");
		    String msgString = jsonObject.toJSONString();
	     	jmsMessagingTemplate.convertAndSend(queue,msgString);
		System.out.println("��Ե�ͨѶ��msg"+msgString);
	}
}
