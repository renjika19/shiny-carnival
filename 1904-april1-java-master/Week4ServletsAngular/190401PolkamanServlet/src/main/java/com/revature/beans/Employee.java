package com.revature.beans;

public class Employee {
	private Integer id;
	private String name;
	private Integer salary;
	private String position;
	public Employee() {
		super();
	}
	public Employee(Integer id, String name, Integer salary, String position) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.position = position;
	}
	public Employee(String name, Integer salary, String position) {
		super();
		this.name = name;
		this.salary = salary;
		this.position = position;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", position=" + position + "]";
	}
	
}
