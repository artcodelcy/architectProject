package com.toov5.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.toov5.utils.MQConnectionUtils;

//生产者 交换机类型 producerFanout类型
public class FanoutProducer {
	//交换机名称
	 private static final String EXCHANGE_NAME = "my_fanout"; 
	 public static void main(String[] args) throws IOException, TimeoutException {
		//建立MQ连接
		 Connection connection = MQConnectionUtils.newConnection();
		//创建通道
	 	 Channel channel = connection.createChannel();
	 	 //生产者绑定交换机
	 	 channel.exchangeDeclare(EXCHANGE_NAME, "fanout");  //交换机名称  交换机类型
	 	 //创建对应的消息 
	 	 String msString = "my_fanout_destination_msg";
	 	 //通过频道 发送消息
	 	 System.out.println("生产者投递消息："+msString);
	 	 channel.basicPublish(EXCHANGE_NAME, "", null, msString.getBytes());
	 	 //关闭通道 和 连接
	 	 channel.close();
	 	 connection.close();
	}
	
} 
