package com.employers.hr.leavemanagement.model;

import jakarta.persistence.*;


@Entity
@Table(name= "employees") 
public class Employee { //top-level class: public/Default

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
	public Employee(){
		
	}
	
     public Employee(Long id, String name, String email){
		this.id=id;
		this.name=name;
		this.email=email;
	}
     
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
