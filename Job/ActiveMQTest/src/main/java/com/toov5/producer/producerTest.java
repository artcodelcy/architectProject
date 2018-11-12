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
	// mqͨѶ��ַ
	private static String url = "tcp://192.168.91.6:61616";
	// ��������
	private static String queueName = "toov5_queue";

	public static void main(String[] args) throws JMSException {
		// �ȴ������ӹ��� ����Ĭ�ϲ���admin admin
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
		// ��������
		Connection connection = activeMQConnectionFactory.createConnection();
		// ��������
		connection.start();
		// �����Ự
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE); // ������ʽ�ύ ���ѷ�ʽĬ���Զ�ǩ��
		// �õ�session ����Ŀ�� ��������
		Queue queue = session.createQueue(queueName);
		// ����������
		MessageProducer producer = session.createProducer(queue); // ��������������Ϣ �Ƿ������queue�����
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);  //Ĭ�Ϸǳ־û��� ���ó־û�
		for (int i = 0; i < 10; i++) {
			// �õ����� ������Ϣ
			TextMessage textMessage = session.createTextMessage("��Ϣ����" + i);
			// ������Ϣ
			producer.send(textMessage);
			session.commit(); //�ύ����
		}
		// �ر�����
		connection.close();
		System.out.println("��Ϣ�������");
	}

}
