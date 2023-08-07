package com.rakesh.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.application.util.CRONUtilities;

@RestController
@RequestMapping("/api/v1/cron")
public class HomeController {
	
	@Autowired
	private CRONUtilities utils;

	@GetMapping("/job1")
	public String job1() {
		utils.scheduledMethod();
		return "Job Intiated";
	}
}
