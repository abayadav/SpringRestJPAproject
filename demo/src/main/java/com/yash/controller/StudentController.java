package com.yash.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.exceptionhandler.CustomValidationException;
import com.yash.pojo.Student;
import com.yash.sevice.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/studentbyid/{id}")
	public Optional<Student> getStudentDetails(@PathVariable("id") int id) {

		Optional<Student> s=service.findStudentById(id);	
		
		if(s.isPresent()){
		   return service.findStudentById(id);
		}
		else {
			throw new CustomValidationException("Student with this id  not present");
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> createStudent(@RequestBody @Valid Student stDto, BindingResult result) {

		if (result.hasErrors()) {

			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_GATEWAY);
		}

		service.saveStudent(stDto);

		return new ResponseEntity<>("Created Student",HttpStatus.CREATED);
	}

	@GetMapping("/allStudent")
	public List<Student> getAllStudent() {

		return service.getAllStudent();
	}

	@PutMapping("/update")
	public <T> ResponseEntity<T> updateStudent(@RequestBody Student stDto, BindingResult result) {

		service.updateStudent(stDto);

		return new ResponseEntity<T>(HttpStatus.ACCEPTED);

	}
	
	@PatchMapping("/updateName")
	public <T> ResponseEntity<T> updateStudentName(@RequestBody Student stDto, BindingResult result) {

		service.updateName(stDto);

		return new ResponseEntity<T>(HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudent(@PathVariable("id") int id) {

		service.deleteStudent(id);
		return "deleted";
	}
	
	
	

}
