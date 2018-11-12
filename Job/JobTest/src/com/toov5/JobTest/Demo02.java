package com.toov5.JobTest;

import java.util.Timer;
import java.util.TimerTask;

public class Demo02 {
    
	private static int count = 0;
	
	public static void main(String[] args) {
		//属于JDK自带的 util包里的哦
	TimerTask timerTask	= new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(++count); 
				
			}
		};
		//定义触发规则
		Timer timer = new Timer();
		//天数
		long delay = 0;  //0表示任意的
		long period = 1000;
		timer.scheduleAtFixedRate(timerTask, delay, period);
	}
	
}
