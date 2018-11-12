package com.toov5.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.toov5.utils.MQConnectionUtils;

//������ ���������� producerFanout����
public class FanoutProducer {
	//����������
	 private static final String EXCHANGE_NAME = "my_fanout"; 
	 public static void main(String[] args) throws IOException, TimeoutException {
		//����MQ����
		 Connection connection = MQConnectionUtils.newConnection();
		//����ͨ��
	 	 Channel channel = connection.createChannel();
	 	 //�����߰󶨽�����
	 	 channel.exchangeDeclare(EXCHANGE_NAME, "fanout");  //����������  ����������
	 	 //������Ӧ����Ϣ 
	 	 String msString = "my_fanout_destination_msg";
	 	 //ͨ��Ƶ�� ������Ϣ
	 	 System.out.println("������Ͷ����Ϣ��"+msString);
	 	 channel.basicPublish(EXCHANGE_NAME, "", null, msString.getBytes());
	 	 //�ر�ͨ�� �� ����
	 	 channel.close();
	 	 connection.close();
	}
	
} 
