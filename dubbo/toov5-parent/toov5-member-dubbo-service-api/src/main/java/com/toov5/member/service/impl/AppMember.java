package com.toov5.member.service.impl;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMember {
   
	public static void main(String[] args) throws IOException {
		
	ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("dubbo-provider.xml");	
	applicationContext.start();  //发布服务直接
	System.out.println("会员启动成功...");	
	System.in.read();  //服务一直保持运行
	
	}
	 
}
