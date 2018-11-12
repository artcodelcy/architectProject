package com.toov5.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutConfig {
	     // �ʼ�����
		private String FANOUT_EMAIL_QUEUE = "fanout_eamil_queue";

		// ���Ŷ���
		private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
		// ���Ŷ���
		private String EXCHANGE_NAME = "fanoutExchange";

	// �������
		  //�ʼ�����
		@Bean
		public Queue fanoutEmailQueue() {
			return new Queue(FANOUT_EMAIL_QUEUE);
		}
		  //���Ŷ���
		@Bean
		public Queue fanoutSMSQueue() {
			return new Queue(FANOUT_SMS_QUEUE);
		}
	//���彻����
		@Bean
		public FanoutExchange fanoutExchange() {
			return new FanoutExchange(EXCHANGE_NAME);
		}
	//���кͽ�������      �������ƺͶ���õķ�������һ��  
		@Bean
		Binding bindingExchangeEamil(Queue fanoutEmailQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(fanoutEmailQueue).to(fanoutExchange);
		}
		
		@Bean
		Binding bindingExchangeSMS(Queue fanoutSMSQueue, FanoutExchange fanoutExchange) {
			return BindingBuilder.bind(fanoutSMSQueue).to(fanoutExchange);
		}

	
}
