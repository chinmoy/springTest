package com.worldbank.service.impl;

import org.springframework.stereotype.Service;

import com.worldbank.model.Result;
import com.worldbank.model.Student;
import com.worldbank.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public Result method1(Student student) {
		Result r = new Result();
		r.setCode(student.getRoll());
		r.setMessage("Message for " + student.getName());
		return r;
	}

}
