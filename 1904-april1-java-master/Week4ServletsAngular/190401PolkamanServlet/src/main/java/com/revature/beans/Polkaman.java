package com.revature.beans;

public class Polkaman {
	private Integer id;
	private String name;
	private Integer hp;
	private Integer str;
	private Integer owner_id;
	
	
	public Polkaman() {
		super();
	}
	public Polkaman(Integer id, String name, Integer hp, Integer str, Integer owner_id) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.str = str;
		this.owner_id = owner_id;
	}
	public Polkaman(String name, Integer hp, Integer str, Integer owner_id) {
		super();
		this.name = name;
		this.hp = hp;
		this.str = str;
		this.owner_id = owner_id;
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
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getStr() {
		return str;
	}
	public void setStr(Integer str) {
		this.str = str;
	}
	public Integer getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}
	@Override
	public String toString() {
		return "Polkaman [id=" + id + ", name=" + name + ", hp=" + hp + ", str=" + str + ", owner_id=" + owner_id + "]";
	}
	
	
}
