package com.example.request;

import org.springframework.stereotype.Component;

@Component
public class RequestObject {
	
    private String studentName;
    private String companyName;
    
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
