package com.toov5.config;

import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigQueue {
   @Value("${my_topic}")
   private String myTopic;
	
	//首先将队列注入到SpringBoot容器中去
    @Bean
	public Topic queue() {
		return new ActiveMQTopic(myTopic);
	} 
	
}
