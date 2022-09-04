package com.mindtree.doctorservice.pojo;


public class Doctor {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String specialised;
	private int noOfPatientVisited;
	public Doctor() {
		super();
	}
	public Doctor(int id, String name, int age, String gender, String specialised, int noOfPatientVisited) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialised = specialised;
		this.noOfPatientVisited = noOfPatientVisited;
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
	public int getNoOfPatientVisited() {
		return noOfPatientVisited;
	}
	public void setNoOfPatientVisited(int noOfPatientVisited) {
		this.noOfPatientVisited = noOfPatientVisited;
	}
	
	
}
