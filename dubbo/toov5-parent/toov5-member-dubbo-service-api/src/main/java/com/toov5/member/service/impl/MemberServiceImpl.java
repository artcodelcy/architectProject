package com.toov5.member.service.impl;

import com.toov5.api.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
     
	   public String getUser(Long userId) {
		System.out.println("����������û�Ա����userId"+userId);
		return "toov5";
	}
	
	
}
