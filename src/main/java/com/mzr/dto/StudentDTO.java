package com.mzr.dto;

public class StudentDTO {
	
	private Integer roll;
	private String name;
	private String course;
	private Double marks;
	
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Double getMarks() {
		return marks;
	}
	public void setMarks(Double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "StudentDTO [roll=" + roll + ", name=" + name + ", course=" + course + ", marks=" + marks + "]";
	}

}
