package com.toov5.member.service.impl;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMember {
   
	public static void main(String[] args) throws IOException {
		
	ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("dubbo-provider.xml");	
	applicationContext.start();  //��������ֱ��
	System.out.println("��Ա�����ɹ�...");	
	System.in.read();  //����һֱ��������
	
	}
	 
}
