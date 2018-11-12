package com.toov5.topicProducer;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
	//�Ѷ���ע����� 
	@Autowired  //��ע��Ĭ������������  �������ļ��� �Ѿ�ע���  @Bean 
	private Topic topic;
	
	//ÿ��5sʱ������з�����Ϣ
	@Scheduled(fixedDelay=5000)  //ÿ���2s����з�����Ϣ
	public void send() {
		String msgString = System.currentTimeMillis()+" ";
		jmsMessagingTemplate.convertAndSend(topic,msgString);
		System.out.println("��������ͨѶ��msg"+msgString);
	}
}
