package com.toov5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //������ʱ����
public class AppProducer {
   public static void main(String[] args) {
	SpringApplication.run(AppProducer.class, args);
}
}
