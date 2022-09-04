package com.mindtree.doctorservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class DoctorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name= "specialised")
	private String specialised;
	
	public DoctorEntity(int id, String name, int age, String gender, String specialised) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialised = specialised;
	}
	
	public DoctorEntity() {
		super();
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialised() {
		return specialised;
	}

	public void setSpecialised(String specialised) {
		this.specialised = specialised;
	}

	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", speciality="
				+ specialised + "]";
	}
	
	
	

}
