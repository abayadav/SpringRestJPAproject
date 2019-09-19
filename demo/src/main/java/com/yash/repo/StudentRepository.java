package com.yash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.yash.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
