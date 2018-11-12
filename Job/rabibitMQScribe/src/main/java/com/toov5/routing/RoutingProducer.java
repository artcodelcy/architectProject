package com.toov5.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.toov5.utils.MQConnectionUtils;

//������ ���������� producerFanout����
public class RoutingProducer {
	//����������
	 private static final String EXCHANGE_NAME = "my_routing"; 
	 public static void main(String[] args) throws IOException, TimeoutException {
		//����MQ����
		 Connection connection = MQConnectionUtils.newConnection();
		//����ͨ��
	 	 Channel channel = connection.createChannel();
	 	 //�����߰󶨽�����
	 	 channel.exchangeDeclare(EXCHANGE_NAME, "direct");  //����������  ����������
	 	 String routingKey="email";
	 	 //������Ӧ����Ϣ 
	 	 String msString = "my_Routing_destination_msg"+routingKey;
	 	 //ͨ��Ƶ�� ������Ϣ
	 	 System.out.println("������Ͷ����Ϣ��"+msString);
	 	 channel.basicPublish(EXCHANGE_NAME, routingKey, null, msString.getBytes());
	 	 //�ر�ͨ�� �� ����
	 	 channel.close();
	 	 connection.close();
	}
	
} 
