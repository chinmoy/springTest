package com.worldbank.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldbank.model.Result;
import com.worldbank.model.Student;
import com.worldbank.service.TestService;

@RestController
@RequestMapping("/api/v1/")
public class studentController {

	TestService testService;

	@Autowired
	studentController(TestService testService) {
		this.testService = testService;
	}

	@PostMapping("/test")
	public Result testMethod(@RequestBody Student student) {

		return testService.method1(student);
	}
}
