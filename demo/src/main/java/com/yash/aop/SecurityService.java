package com.yash.aop;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.yash.exceptionhandler.RecordNotPresentException;
import com.yash.pojo.Student;
import com.yash.sevice.StudentService;

@Configuration
@Aspect
public class SecurityService {

	@Autowired
	StudentService studentService;
	
	@Pointcut(value="execution(*  com.yash.controller.StudentController.deleteStudent(..))")
	public void method1(){
		
	}

	
	@Before(value="method1()")
	public void checkStudentBeforeDelete(JoinPoint jp){
		
		Object [] obj=jp.getArgs();
		Integer id=(Integer) obj[0];
		
		Optional<Student> s=studentService.findStudentById(id);
		
		if(!s.isPresent()){
			throw new RecordNotPresentException("Records is not presnt"); 
		}
	
		
	}
}
