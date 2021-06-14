package com.revature.serialization;

import java.io.Serializable;

public class Cereal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private transient String name;
	private transient float price;
	public Cereal(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Cereal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public strictfp float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cereal [name=" + name + ", price=" + price + "]";
	}
	

}
