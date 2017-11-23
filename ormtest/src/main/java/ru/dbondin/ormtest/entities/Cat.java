package ru.dbondin.ormtest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cat")
public class Cat {

	public static enum Sex {
		MALE, FEMALE
	};
	
	@Id
	@SequenceGenerator(name="cat_sequence_generator", sequenceName="cat_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cat_sequence_generator")
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="age")
	private Integer age;

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	private Breed breed;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sex", nullable=true)
	private Sex sex;
	
	public Sex getSex() {
		return sex;
	}
	
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public Breed getBreed() {
		return breed;
	}
	
	public void setBreed(Breed breed) {
		this.breed = breed;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("[id=%d,name=%s,age=%d,sex=%s]", id, name, age, sex);
	}
}
