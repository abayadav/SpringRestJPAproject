package com.yash.controller;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pojo.Account;
import com.yash.pojo.Address;
import com.yash.pojo.Company;
import com.yash.pojo.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping("/saveemp")
	@Transactional
	public void saveEmp(@RequestBody Employee emp) {

		em.persist(emp);

	}

	@GetMapping("/getemp")
	@Transactional
	public List<Employee> saveEmp() {

		Query q = em.createQuery("Select a from Employee a");

		List<Employee> accList = (List<Employee>) q.getResultList();
        accList.forEach(System.out::println);

		return accList;
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	@Transactional
	public int  deleteEmp(@PathVariable Integer id) {

		em.remove(em.find(Employee.class,id));
		
		return 1;
	}
	
	@DeleteMapping("/deleteAdd/{id}")
	@Transactional
	public int  deleteAdd(@PathVariable Integer id) {

		em.remove(em.find(Address.class,id));
		
		return 1;
	}
	
	

}
