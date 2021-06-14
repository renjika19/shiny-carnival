package com.revature.beans;

public class Owner {
	private Integer id;
	private String name;
	private Integer money;
	private String username;
	private String password;

	public Owner(String name, Integer money, String username, String password) {
		super();
		this.name = name;
		this.money = money;
		this.username = username;
		this.password = password;
	}
	public Owner(Integer id, String name, Integer money, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.username = username;
		this.password = password;
	}
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", money=" + money + ", username=" + username + ", password="
				+ password + "]";
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
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
