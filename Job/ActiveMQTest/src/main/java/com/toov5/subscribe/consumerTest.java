package com.toov5.subscribe;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;


public class consumerTest {
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

		
		 
		//创建消费者
		MessageConsumer consumer = session.createConsumer(topic);
		//启动监听 监听消息
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
			    //强制转换
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("consumer 消费 producer:"+textMessage.getText());
				} catch (JMSException e) {
					
					e.printStackTrace();
				}
			}
		});
		 //监听时候 不要关闭连接 关闭就不监听了 一只处于监听状态 （长连接）
		 
	}

}
