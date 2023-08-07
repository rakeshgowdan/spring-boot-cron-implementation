package com.rakesh.application.util;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CRONUtilities {

	//execution of a task at every minute 15th second.
	@Scheduled(cron = "* * * * * *") 
	   public void scheduledMethod() {
	      System.out.println("Hello cron Scheduler Service: " +LocalDateTime.now()); 
	   } 
}
