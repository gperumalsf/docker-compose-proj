package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dao.StudentInfo;

@Repository
public interface StudentRepo extends CrudRepository<StudentInfo, Long> {
	StudentInfo findById(long id);
}
