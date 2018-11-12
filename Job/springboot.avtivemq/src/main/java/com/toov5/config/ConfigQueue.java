package com.toov5.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigQueue {
   @Value("${my_queue}")
   private String myQueue;
	
	//���Ƚ�����ע�뵽SpringBoot������ȥ
    @Bean
	public Queue queue() {
		return new ActiveMQQueue(myQueue); 
	} 
	
}
