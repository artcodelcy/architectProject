package com.toov5.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.toov5.utils.MQConnectionUtils;

//�ʼ�������
public class ConsumerEmailRouting {
	private static final String EMAIL_QUEUE ="email_queue_routing";
	//����������
   private static final String EXCHANGE_NAME = "my_routing"; 
     public static void main(String[] args) throws IOException, TimeoutException {
    	 System.out.println("�ʼ�����������");
    	//����MQ����
		 Connection connection = MQConnectionUtils.newConnection(); 
		//����ͨ��
	 	 Channel channel = connection.createChannel();
	 	 
	    //��������������
	 	 channel.queueDeclare(EMAIL_QUEUE, false, false, false, null);
	 	//�����߶��а� ·��
	 	 channel.queueBind(EMAIL_QUEUE, EXCHANGE_NAME, "email");
	 	 //�����߼�����Ϣ
	  DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
	 		 //��д��������
	 		@Override
	 		public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
	 				throws IOException { 			
	 			String msg = new String(body,"UTF-8");
	 			System.out.println("�ʼ������߻�ȡ��������Ϣ"+msg);
	 		}
	 	};
	 	channel.basicConsume(EMAIL_QUEUE,true, defaultConsumer);   //�󶨶��� �¼�����
	 	   
	}
}
