package com.toov5.msg.SMS;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  //ע�ᵽSpring ��������
@RabbitListener(queues="fanout_sms_queue")   //����
public class SMSConsumer {
	
	@RabbitHandler  //��ʾ������Ϣ
   public void process(String mString) {
	   System.out.println("���������߻�ȡ��������Ϣmsg"+mString);
   }
}
