package com.toov5.subscribe;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;


public class producerTest {
	// mqͨѶ��ַ
	private static String url = "tcp://192.168.91.6:61616";
	// ��Ϣ����
	private static String topicName = "toov5_topic";

	public static void main(String[] args) throws JMSException {
		// �ȴ������ӹ��� ����Ĭ�ϲ���admin admin
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
		// ��������
		Connection connection = activeMQConnectionFactory.createConnection();
		// ��������
		connection.start();
		// �����Ự
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); // �Ƿ���Ҫ����ʽ�ύ ���ѷ�ʽĬ���Զ�ǩ��
		
		
		// �õ�session ����Ŀ�� ��������
		Topic topic =session.createTopic(topicName);

		// ����������
		MessageProducer producer = session.createProducer(topic); // ��������������Ϣ �Ƿ������queue�����
		for (int i = 1; i < 10; i++) {
			// �õ����� ������Ϣ
			TextMessage textMessage = session.createTextMessage("��Ϣ����" + i);
			// ������Ϣ
			producer.send(textMessage);
		}
		// �ر�����
		connection.close();
		System.out.println("��Ϣ�������");
	}

}
