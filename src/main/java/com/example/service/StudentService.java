package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentInfo;
import com.example.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	
    public void storeStudentInfo(StudentInfo studentInfo) {
        studentRepo.save(studentInfo);
    }
    
    public StudentInfo retrieveStudentInfo(long id) {
    	StudentInfo studentInfo = new StudentInfo();
    	studentInfo = studentRepo.findById(id);
    	return studentInfo;
    }
    
    
	
}
