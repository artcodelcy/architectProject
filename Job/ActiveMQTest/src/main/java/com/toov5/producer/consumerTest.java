package com.toov5.producer;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class consumerTest {
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
		final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE); // �Ƿ���������ʽ�ύ ���ѷ�ʽĬ���Զ�ǩ��
		// �õ�session ����Ŀ�� ��������
		Queue queue = session.createQueue(queueName);
		
		
		 
		//����������
		MessageConsumer consumer = session.createConsumer(queue);
		//�������� ������Ϣ
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
			    //ǿ��ת��
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("consumer ���� producer:"+textMessage.getText());
//					textMessage.acknowledge();
					session.commit();
				} catch (JMSException e) {
					
					e.printStackTrace();
				}
			}
		});
		 //����ʱ�� ��Ҫ�ر����� �رվͲ������� һֻ���ڼ���״̬ �������ӣ�
		 
	}

}
