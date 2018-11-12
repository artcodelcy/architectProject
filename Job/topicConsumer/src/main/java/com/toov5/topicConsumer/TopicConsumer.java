package com.toov5.topicConsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
   
	@JmsListener(destination= "${my_topic}")    //�����ע��ȥ���� �����Ķ���
	public void receiver(String msg) {
		System.out.println("�����߳ɹ���ȡ�������ߵ���Ϣ��msg"+msg);
	}
	
	
}
