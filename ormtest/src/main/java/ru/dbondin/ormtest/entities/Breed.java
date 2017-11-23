package ru.dbondin.ormtest.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Breed {

	@Id
	@SequenceGenerator(name="breed_sequence_generator", sequenceName="breed_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="breed_sequence_generator")
	@Column
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="descr")
	private String description;
	
	@Column(name="rating", nullable=false)
	private int rating;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="breed")
	private List<Cat> cats = new ArrayList<>();
	
	public List<Cat> getCats() {
		return cats;
	}
	
	public void setCats(List<Cat> cats) {
		this.cats = cats;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return String.format("[id=%d,name=%s,description=%s,rating=%d]", id, name, description, rating);
	}
}
