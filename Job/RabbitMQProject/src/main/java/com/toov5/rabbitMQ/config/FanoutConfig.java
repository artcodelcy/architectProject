package com.toov5.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutConfig {
	     // 邮件队列
		private String FANOUT_EMAIL_QUEUE = "fanout_eamil_queue";

		// 短信队列
		private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
		// 短信队列
		private String EXCHANGE_NAME = "fanoutExchange";

	// 定义队列
		  //邮件队列
		@Bean
		public Queue fanoutEmailQueue() {
			return new Queue(FANOUT_EMAIL_QUEUE);
		}
		  //短信队列
		@Bean
		public Queue fanoutSMSQueue() {
			return new Queue(FANOUT_SMS_QUEUE);
		}
	//定义交换机
		@Bean
		public FanoutExchange fanoutExchange() {
			return new FanoutExchange(EXCHANGE_NAME);
		}
	//队列和交换机绑定      参数名称和定义好的方法名称一致  
		@Bean
		Binding bindingExchangeEamil(Queue fanoutEmailQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(fanoutEmailQueue).to(fanoutExchange);
		}
		
		@Bean
		Binding bindingExchangeSMS(Queue fanoutSMSQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(fanoutSMSQueue).to(fanoutExchange);
		}

	
}
