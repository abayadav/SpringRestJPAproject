package com.yash.sevice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pojo.Student;
import com.yash.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void saveStudent(Student st) {

		studentRepository.save(st);

	}

	@Override
	public List<Student> getAllStudent() {
		
		return  studentRepository.findAll();
	}

	@Override
	public Optional<Student> findStudentById(Integer id) {
	
		return studentRepository.findById(id);
	}

	@Override
	public Student updateStudent( Student stDto) {
		
		return studentRepository.save(stDto);
	}

	@Override
	public void deleteStudent(int id) {
		
		 studentRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void updateName(Student st) {
		
		studentRepository.save(st);
		
	}

}
