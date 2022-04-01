package com.example.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dao.StudentInfo;
import com.example.repo.StudentRepo;

//@Component
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	final static Logger logger = Logger.getLogger(StudentService.class);
	
	public void storeStudentInfo(StudentInfo studentInfo) {
        studentRepo.save(studentInfo);
        logger.info("Data Loaded: " + studentInfo.toString());
    }
    
    public StudentInfo retrieveStudentInfo(long id) {
    	StudentInfo studentInfo = new StudentInfo();
    	studentInfo = studentRepo.findById(id);
        logger.info("Data Retrieved: " + studentInfo.toString());
    	return studentInfo;
    }
    
    
	
}
