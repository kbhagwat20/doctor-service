package com.mindtree.doctorservice.pojo;

public class Patient {
	private int id;
	private String name;
	private int visitedDoctor;
	private String dateOfVisit;
	
	public Patient() {
		super();
	}
	public Patient(int id, String name, int visitedDoctor, String dateOfVisit) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
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
	public int getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(int visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	
	
}
