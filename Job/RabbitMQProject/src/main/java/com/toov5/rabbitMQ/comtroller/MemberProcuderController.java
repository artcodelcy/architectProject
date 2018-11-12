package com.toov5.rabbitMQ.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toov5.rabbitMQ.Producer.FanoutProducer;

@RestController
public class MemberProcuderController {
   @Autowired
   private FanoutProducer fanoutProducer;
   
   @RequestMapping("/sendMsg")
   public String  sendMsg(String queueName) {
	   fanoutProducer.send(queueName);
	   return "success";
   }
}
