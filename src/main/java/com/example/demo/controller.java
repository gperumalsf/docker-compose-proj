package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dao.StudentInfo;
import com.example.request.RequestObject;
import com.example.service.StudentService;

@RestController
public class controller {
	
//	@Autowired
//	private StudentService studentService;
	StudentService studentService = new StudentService();

	final static Logger logger = Logger.getLogger(controller.class);
	
	@GetMapping(path="/")
	public String home() {
		return "Welcome to the GAS Project!";
	}
	
	@PostMapping(path="/addRecord")
	public void addStudent(@RequestBody RequestObject requestObject) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentName(requestObject.getStudentName());
		studentInfo.setCompanyName(requestObject.getCompanyName());
		try {
			studentService.storeStudentInfo(studentInfo);	
		} catch (Exception e) {
			logger.error("Error while storing into the database: " + e.getMessage());
		}
	}
	
	@GetMapping(path="/getRecord")
	public StudentInfo retrieveById(long id) {
		StudentInfo studentInfo = new StudentInfo();
		try {
			studentInfo = studentService.retrieveStudentInfo(id);
		} catch (Exception e) {
			logger.error("Error while retrieving data from the database: " + e.getMessage());
		}
		return studentInfo;
	}
	
}
