package com.mockito.potential_stubbing_problem;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private double salary;
	private String role;

	public Employee() {

	}

	public Employee(int id, String name, double salary, String role) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
