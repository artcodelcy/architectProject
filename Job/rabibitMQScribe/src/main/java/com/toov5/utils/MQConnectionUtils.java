package com.toov5.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
//û�����ɵ�����  VirtualHost ��Ҫ����
public class MQConnectionUtils {
    //�����µ�����
	public static Connection newConnection() throws IOException, TimeoutException {
		 //�������ӹ���
	ConnectionFactory factory= new ConnectionFactory();
	//���ӵ�ַ
	factory.setHost("192.168.91.6");
	//�û�����
	factory.setUsername("admin");
	//�û�����
	factory.setPassword("admin");
	//amqp�˿ں�
	factory.setPort(5672);
	//����virtualhost
	factory.setVirtualHost("/admin_toov5");
	Connection connection = factory.newConnection();
		return connection;
	}
	
	
}
