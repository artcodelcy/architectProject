package com.toov5.msg.email;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  //ע�ᵽSpring ��������
@RabbitListener(queues="fanout_eamil_queue")   //����
public class EmailConsumer {
	
	@RabbitHandler  //��ʾ������Ϣ
   public void process(String mString) {
	   System.out.println("�ʼ������߻�ȡ��������Ϣmsg"+mString);
   }
}
