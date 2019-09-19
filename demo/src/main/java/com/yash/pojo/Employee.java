package com.yash.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer emp_id;

	String emp_name;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "employee")
	List<Address> add = new ArrayList<>();
	
	
	//@JsonManagedReference
	@ManyToOne()
	Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {

		this.emp_name = emp_name;
	}

	public List<Address> getAdd() {

		return add;
	}

	public void setAdd(List<Address> add) {
		for (Address i : add) {
			i.setEmployee(this);
		}
		this.add.addAll(add);

	}

	@Override
	public String toString() {
		return "Employee [add=" + add + ", emp_id=" + emp_id + ", emp_name=" + emp_name + "]";
	}

	

}
