package com.toov5.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//��ʱ����� ҵ��
		System.out.println("quartz MyJob date:" + new Date().getTime());
	}
}
