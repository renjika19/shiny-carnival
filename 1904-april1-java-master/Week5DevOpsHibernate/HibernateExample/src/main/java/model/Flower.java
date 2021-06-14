package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Flower")
public class Flower {
	
	@Id
	@Column(name="f_id")
	@SequenceGenerator(sequenceName="flower_seq", name="f_seq")
	@GeneratedValue(generator="f_seq", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="f_petals")
	private int petals;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetals() {
		return petals;
	}
	public void setPetals(int petals) {
		this.petals = petals;
	}
	public Flower() {
		super();
	}
	public Flower(int id, int petals) {
		super();
		this.id = id;
		this.petals = petals;
	}
	public Flower(int petals) {
		super();
		this.petals = petals;
	}
	
	@Override
	public String toString() {
		return "Flower [id=" + id + ", petals=" + petals + "]";
	}
	
	
}
