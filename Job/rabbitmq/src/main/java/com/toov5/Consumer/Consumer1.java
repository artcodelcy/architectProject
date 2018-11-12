package com.toov5.Consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.toov5.utils.MQConnectionUtils;

public class Consumer1 {
  
	 //队列名称
		private static final String QUEUE_NAME = "test_queue";
		
		public static void main(String[] args) throws IOException, TimeoutException {
			System.out.println("消费者启动..........1");
			//创建新的连接
		Connection connection = MQConnectionUtils.newConnection();
		   //创建Channel
	        final Channel channel = connection.createChannel();
	        // 消费者关联队列
	         channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	         channel.basicQos(1);
	          DefaultConsumer defaultConsumerr = new DefaultConsumer(channel) {
	        	  //监听获取消息
	        	    @Override
	        	    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
	        	    		byte[] body) throws IOException {
	        	    	String msg =new String(body,"UTF-8");
	        	    	System.out.println("消费者获取生产者消息："+msg);
	        	    	try {
	        	    		//模拟应答等待时间
							Thread.sleep(1000);
						} catch (Exception e) {
							
						}finally {
	        	       	channel.basicAck(envelope.getDeliveryTag(), false);  //手动应答 告诉消息队列服务器 消费成功
						}
	        	    }
	          };
	        //牵手模式设置  默认自动应答模式  true:自动应答模式  
	          channel.basicConsume(QUEUE_NAME, false, defaultConsumerr);//	fanse手动应答          

		}
}
