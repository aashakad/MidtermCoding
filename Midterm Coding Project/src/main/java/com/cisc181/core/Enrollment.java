package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID EnrollmentID;
	private UUID StudentID;
	private double Grade;
	
	private Enrollment()  {	
	}
	
	public Enrollment(UUID Section, UUID Student) {
		this.SectionID = Section;
		this.StudentID = Student;
		this.EnrollmentID = UUID.randomUUID();
	}
	
	public UUID getSectionID() {
		return SectionID;
	}
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	public UUID getStudentID() {
		return StudentID;
	}
	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}
	public double getGrade() {
		return Grade;
	}
	public void setGrade(double grade) {
		Grade = grade;
	}
	
	
}
