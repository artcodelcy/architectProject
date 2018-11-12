package com.toov5.activemqConsumer;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class P2PConsumer {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String toEmail;

	@JmsListener(destination = "${my_queue}") // �����ע��ȥ���� �����Ķ���
	public void receiver(String msg) throws Exception {
		if (StringUtils.isEmpty(msg)) {
			return;
		}
		// ����json
		JSONObject parseObject  =  JSONObject.parseObject(msg);  //ת�ɶ���
		String userName = parseObject.getString("username");
		String email = parseObject.getString("email");
		sendSimpleMail(email, userName);
		System.out.println("�����߳ɹ���ȡ�������ߵ���Ϣ��msg" + msg);
	}

	public void sendSimpleMail(String email, String userName) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		// �ʼ�����Դ �Լ����Լ�
		message.setFrom(email);
		// ���͸�˭
		message.setTo(toEmail);
		// �ʼ�����
		message.setSubject("toov5����԰����");
		// �ʼ�����
		message.setText("hello:" + userName + "���ǳ�Ϊ������!");
		// �����ʼ�
		javaMailSender.send(message);
		System.out.println("�ʼ��������," + JSONObject.toJSONString(message));
	}

}