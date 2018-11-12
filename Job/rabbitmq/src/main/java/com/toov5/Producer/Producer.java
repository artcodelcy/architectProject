package com.toov5.Producer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.toov5.utils.MQConnectionUtils;

public class Producer {
	// ��������
	private static final String UEUE_NAME = "test_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		// �����µ�����
		Connection connection = MQConnectionUtils.newConnection();
		// ����Channel
		Channel channel = connection.createChannel();
		// ��������
		channel.queueDeclare(UEUE_NAME, false, false, false, null);
		channel.basicQos(1); // ��֤ ȡһ������
		for (int i = 0; i < 10; i++) {
			// ����message
			String msg = "toov5_message";
			System.out.println("������Ͷ����Ϣ" + msg + i);
			// �����߷�����Ϣ
			channel.basicPublish("", UEUE_NAME, null, msg.getBytes());
		}
		// �ر�ͨ��������
		channel.close();
		connection.close();

	}
}
