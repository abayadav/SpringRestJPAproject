package com.yash.sevice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.yash.pojo.Student;

public interface StudentService {

	public void saveStudent(Student st);
	
	public List<Student> getAllStudent();
	
	public Optional<Student> findStudentById(Integer id);

	public Student updateStudent(@Valid Student stDto);
	
	public void deleteStudent(int id);
	
	public void updateName(Student st);
	
	

}
