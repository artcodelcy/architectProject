package com.toov5.member.service.impl;

import com.toov5.api.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
     
	   public String getUser(Long userId) {
		System.out.println("订单服务调用会员服务：userId"+userId);
		return "toov5";
	}
	
	
}
