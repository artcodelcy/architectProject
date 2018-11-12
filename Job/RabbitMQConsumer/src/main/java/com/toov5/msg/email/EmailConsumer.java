package com.toov5.msg.email;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  //注册到Spring 容器里面
@RabbitListener(queues="fanout_eamil_queue")   //监听
public class EmailConsumer {
	
	@RabbitHandler  //表示接收消息
   public void process(String mString) {
	   System.out.println("邮件消费者获取生产者消息msg"+mString);
   }
}
