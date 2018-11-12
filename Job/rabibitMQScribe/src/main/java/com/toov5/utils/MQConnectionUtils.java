package com.toov5.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
//没有做成单例的  VirtualHost 需要复用
public class MQConnectionUtils {
    //创建新的连接
	public static Connection newConnection() throws IOException, TimeoutException {
		 //创建连接工厂
	ConnectionFactory factory= new ConnectionFactory();
	//链接地址
	factory.setHost("192.168.91.6");
	//用户名称
	factory.setUsername("admin");
	//用户密码
	factory.setPassword("admin");
	//amqp端口号
	factory.setPort(5672);
	//连接virtualhost
	factory.setVirtualHost("/admin_toov5");
	Connection connection = factory.newConnection();
		return connection;
	}
	
	
}
