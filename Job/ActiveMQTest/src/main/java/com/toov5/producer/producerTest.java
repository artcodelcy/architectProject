package com.toov5.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class producerTest {
	// mq通讯地址
	private static String url = "tcp://192.168.91.6:61616";
	// 队列名称
	private static String queueName = "toov5_queue";

	public static void main(String[] args) throws JMSException {
		// 先创建连接工厂 密码默认采用admin admin
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
		// 创建连接
		Connection connection = activeMQConnectionFactory.createConnection();
		// 启动连接
		connection.start();
		// 创建会话
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE); // 以事务方式提交 消费方式默认自动签收
		// 拿到session 创建目标 创建队列
		Queue queue = session.createQueue(queueName);
		// 创建生产者
		MessageProducer producer = session.createProducer(queue); // 生产者生产的消息 是放在这个queue里面的
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);  //默认非持久化的 设置持久化
		for (int i = 0; i < 10; i++) {
			// 拿到队列 创建消息
			TextMessage textMessage = session.createTextMessage("消息内容" + i);
			// 发送消息
			producer.send(textMessage);
			session.commit(); //提交事务
		}
		// 关闭连接
		connection.close();
		System.out.println("消息发送完毕");
	}

}
