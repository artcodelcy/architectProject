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

		
		 
		//����������
		MessageConsumer consumer = session.createConsumer(topic);
		//�������� ������Ϣ
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
			    //ǿ��ת��
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("consumer ���� producer:"+textMessage.getText());
				} catch (JMSException e) {
					
					e.printStackTrace();
				}
			}
		});
		 //����ʱ�� ��Ҫ�ر����� �رվͲ������� һֻ���ڼ���״̬ �������ӣ�
		 
	}

}
