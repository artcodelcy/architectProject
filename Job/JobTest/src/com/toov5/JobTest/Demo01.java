package com.toov5.JobTest;

public class Demo01 {
   
	static long count = 0;
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					count++;
					System.out.println(count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
	 
	
}
