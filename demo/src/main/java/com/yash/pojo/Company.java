package com.yash.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int company_id;
	
	String company_name;
	
	@JsonBackReference
    @OneToMany(mappedBy="company", cascade=CascadeType.ALL)
    List<Employee> emp= new ArrayList<>();;
	
    public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		
		
		this.company_name = company_name;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		
		for (Employee i : emp) {
			
			i.setCompany(this);
		}
		this.emp.addAll(emp);
	}

	
	
   
	
}
