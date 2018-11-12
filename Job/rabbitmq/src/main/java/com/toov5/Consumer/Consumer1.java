package com.toov5.Consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.toov5.utils.MQConnectionUtils;

public class Consumer1 {
  
	 //��������
		private static final String QUEUE_NAME = "test_queue";
		
		public static void main(String[] args) throws IOException, TimeoutException {
			System.out.println("����������..........1");
			//�����µ�����
		Connection connection = MQConnectionUtils.newConnection();
		   //����Channel
	        final Channel channel = connection.createChannel();
	        // �����߹�������
	         channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	         channel.basicQos(1);
	          DefaultConsumer defaultConsumerr = new DefaultConsumer(channel) {
	        	  //������ȡ��Ϣ
	        	    @Override
	        	    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
	        	    		byte[] body) throws IOException {
	        	    	String msg =new String(body,"UTF-8");
	        	    	System.out.println("�����߻�ȡ��������Ϣ��"+msg);
	        	    	try {
	        	    		//ģ��Ӧ��ȴ�ʱ��
							Thread.sleep(1000);
						} catch (Exception e) {
							
						}finally {
	        	       	channel.basicAck(envelope.getDeliveryTag(), false);  //�ֶ�Ӧ�� ������Ϣ���з����� ���ѳɹ�
						}
	        	    }
	          };
	        //ǣ��ģʽ����  Ĭ���Զ�Ӧ��ģʽ  true:�Զ�Ӧ��ģʽ  
	          channel.basicConsume(QUEUE_NAME, false, defaultConsumerr);//	fanse�ֶ�Ӧ��          

		}
}
