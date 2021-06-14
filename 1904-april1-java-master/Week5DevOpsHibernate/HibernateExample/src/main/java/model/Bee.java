package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Bee")
public class Bee {
	
	@Id
	@Column(name="b_id")
	@SequenceGenerator(sequenceName="bee_seq", name="b_seq")
	@GeneratedValue(generator="b_seq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="b_age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name="b_beehive")
	private Beehive beehive;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="bee_flower_jt", 
		joinColumns= @JoinColumn(name="b_id"),	//Column for THIS table
		inverseJoinColumns= @JoinColumn(name="f_id"))//Column for OTHER table
	private List<Flower> flowers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Beehive getBeehive() {
		return beehive;
	}

	public void setBeehive(Beehive beehive) {
		this.beehive = beehive;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public Bee() {
		super();
	}

	public Bee(int id, int age, Beehive beehive) {
		super();
		this.id = id;
		this.age = age;
		this.beehive = beehive;
	}

	public Bee(int age, Beehive beehive) {
		super();
		this.age = age;
		this.beehive = beehive;
	}

	@Override
	public String toString() {
		return "Bee [id=" + id + ", age=" + age + ", beehive=" + beehive + ", flowers=" + flowers + "]";
	}
	
}
