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

	@JmsListener(destination = "${my_queue}") // 用这个注解去监听 监听的队列
	public void receiver(String msg) throws Exception {
		if (StringUtils.isEmpty(msg)) {
			return;
		}
		// 解析json
		JSONObject parseObject  =  JSONObject.parseObject(msg);  //转成对象
		String userName = parseObject.getString("username");
		String email = parseObject.getString("email");
		sendSimpleMail(email, userName);
		System.out.println("消费者成功获取到生产者的消息，msg" + msg);
	}

	public void sendSimpleMail(String email, String userName) throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		// 邮件的来源 自己发自己
		message.setFrom(email);
		// 发送给谁
		message.setTo(toEmail);
		// 邮件标题
		message.setSubject("toov5博客园提醒");
		// 邮件内容
		message.setText("hello:" + userName + "我们成为好朋友!");
		// 发送邮件
		javaMailSender.send(message);
		System.out.println("邮件发送完成," + JSONObject.toJSONString(message));
	}

}