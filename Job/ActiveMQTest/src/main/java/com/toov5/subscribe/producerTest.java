package com.toov5.subscribe;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;


public class producerTest {
	// mq通讯地址
	private static String url = "tcp://192.168.91.6:61616";
	// 消息名称
	private static String topicName = "toov5_topic";

	public static void main(String[] args) throws JMSException {
		// 先创建连接工厂 密码默认采用admin admin
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
		// 创建连接
		Connection connection = activeMQConnectionFactory.createConnection();
		// 启动连接
		connection.start();
		// 创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); // 是否需要事务方式提交 消费方式默认自动签收
		
		
		// 拿到session 创建目标 创建主题
		Topic topic =session.createTopic(topicName);

		// 创建生产者
		MessageProducer producer = session.createProducer(topic); // 生产者生产的消息 是放在这个queue里面的
		for (int i = 1; i < 10; i++) {
			// 拿到队列 创建消息
			TextMessage textMessage = session.createTextMessage("消息内容" + i);
			// 发送消息
			producer.send(textMessage);
		}
		// 关闭连接
		connection.close();
		System.out.println("消息发送完毕");
	}

}
