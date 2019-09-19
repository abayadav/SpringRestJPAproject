package com.yash.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {

	@Id
    Integer add_id;
	String state;
	String country;
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	@JsonBackReference
	Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getAdd_id() {
		return add_id;
	}
	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", state=" + state + ", country=" + country + "]";
	}
	
	
	
}
