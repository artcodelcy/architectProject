package com.toov5.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.toov5.utils.MQConnectionUtils;

//�ʼ�������
public class ConsumerSMSTopic {
	private static final String SMS_QUEUE ="sms_queue_topic";
	//����������
   private static final String EXCHANGE_NAME = "my_topic"; 
     public static void main(String[] args) throws IOException, TimeoutException {
    	 System.out.println("��������������");
    	//����MQ����
		 Connection connection = MQConnectionUtils.newConnection(); 
		//����ͨ��
	 	 Channel channel = connection.createChannel();
	 	 
	    //��������������
	 	 channel.queueDeclare(SMS_QUEUE, false, false, false, null);
	 	//�����߶��а� ·��
	 	channel.queueBind(SMS_QUEUE, EXCHANGE_NAME, "log.#");
	 	 //�����߼�����Ϣ
	  DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
	 		 //��д��������
	 		@Override
	 		public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
	 				throws IOException { 			
	 			String msg = new String(body,"UTF-8");
	 			System.out.println("���������߻�ȡ��������Ϣ"+msg);
	 		}
	 	};
	 	channel.basicConsume(SMS_QUEUE,true, defaultConsumer);   //�󶨶��� �¼�����
	 	   
	}
}
