package com.toov5.JobTest;

import java.util.Timer;
import java.util.TimerTask;

public class Demo02 {
    
	private static int count = 0;
	
	public static void main(String[] args) {
		//����JDK�Դ��� util�����Ŷ
	TimerTask timerTask	= new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(++count); 
				
			}
		};
		//���崥������
		Timer timer = new Timer();
		//����
		long delay = 0;  //0��ʾ�����
		long period = 1000;
		timer.scheduleAtFixedRate(timerTask, delay, period);
	}
	
}
