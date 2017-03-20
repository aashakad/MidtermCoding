package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	public static ArrayList<Course> courseList;
	public static ArrayList<Semester> semList;
	public static ArrayList<Section> secList;
	public static ArrayList<Student> stList;
	

	@BeforeClass
	public static void setup() {
		Course c1= new Course("CISC181", 3, eMajor.COMPSI);
		Course c2= new Course("CHEM207", 4, eMajor.CHEM);
		Course c3= new Course("PHYS207", 4, eMajor.PHYSICS);
		
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);
		
		Student_Test.courseList = courseList;
		
		String dateFormat = "mm/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		ArrayList<Date> dates = new ArrayList<Date>();
		ArrayList<Date> brdates = new ArrayList<Date>();
		ArrayList<String> sdates = new ArrayList<String>();
		ArrayList<String> bdates = new ArrayList<String>();
		Date d = null;
		
		sdates.add("08/01/2016");
		sdates.add("12/17/2016");
		sdates.add("02/06/2017");
		sdates.add("05/26/2017");
		
		for(String s : sdates)
			try {
				d = format.parse(s);
				dates.add(d);
			} catch (ParseException e) {
				System.out.println("Date formatted incorrectly");
			}
			
		
		Semester fall = new Semester(dates.get(0), dates.get(1));
		Semester spring = new Semester(dates.get(2), dates.get(3));
		
		ArrayList<Semester> semList = new ArrayList<Semester>();
		semList.add(fall);
		semList.add(spring);
		
		Student_Test.semList = semList;
		
		Section cs1 = new Section(courseList.get(0).getCourseID(), semList.get(0).getSemesterID(), 100);
		Section cs2 = new Section(courseList.get(0).getCourseID(), semList.get(1).getSemesterID(), 150);
		Section cm1 = new Section(courseList.get(1).getCourseID(), semList.get(0).getSemesterID(), 300);
		Section cm2 = new Section(courseList.get(1).getCourseID(), semList.get(1).getSemesterID(), 100);
		Section ph1 = new Section(courseList.get(2).getCourseID(), semList.get(0).getSemesterID(), 150);
		Section ph2 = new Section(courseList.get(2).getCourseID(), semList.get(1).getSemesterID(), 200);
		
		ArrayList<Section> secList = new ArrayList<Section>();
		secList.add(cs1);
		secList.add(cs2);
		secList.add(cm1);
		secList.add(cm2);
		secList.add(ph1);
		secList.add(ph2);
		
		Student_Test.secList = secList;
		
		bdates.add("01/12/1994");
		bdates.add("02/28/1987");
		bdates.add("03/05/1996");
		bdates.add("04/23/1998");
		bdates.add("05/19/1993");
		bdates.add("06/23/1997");
		bdates.add("07/07/1992");
		bdates.add("08/29/1995");
		bdates.add("09/01/2000");
		bdates.add("10/26/1998");
		
		for(String s : bdates)
			try {
				d = format.parse(s);
				brdates.add(d);
			} catch (ParseException e) {
				System.out.println("Date formatted incorrectly");
			}
		
		Student s1 = new Student("Harry", "James", "Potter", brdates.get(0), eMajor.CHEM, "4 Privet Drive, Surrey", 
				"(123)-345-5678", "hp@hogwarts.com");
		Student s2 = new Student("Brian", "Percy", "Ruckler", brdates.get(1), eMajor.COMPSI, "5 South Chapel St, Newark", 
				"(925)-384-9070", "bpr@gmail.com");
		Student s3 = new Student("Emma", "Marie", "Sills", brdates.get(2), eMajor.PHYSICS, "230 E Main St, Newark", 
				"(971)-227-8140", "ems@yahoo.com");
		Student s4 = new Student("Sofia", "Victory", "Chase", brdates.get(3), eMajor.COMPSI , "218 Ayrshire Farm Ln, Stanford", 
				"(457)-355-2747", "svc@gmail.com");
		Student s5 = new Student("Annabeth", "Pearl", "Jackson", brdates.get(4),eMajor.PHYSICS, "111 Christiana Dr, Newark", 
				"(302)-553-6185", "apj@hotmail.com");
		Student s6 = new Student("Maddi", "Taylor", "Marsh", brdates.get(5), eMajor.CHEM, "230 E Main St, Newark", 
				"(971)-227-8140", "mtm@yahoo.com");
		Student s7 = new Student("Sarah", "Ashley", "Bedard", brdates.get(6), eMajor.PHYSICS, "5 South Chapel St, Newark", 
				"(302)-553-6185", "sab@yahoo.com");
		Student s8 = new Student("Marie", "Anna", "Sills", brdates.get(7), eMajor.COMPSI, "111 Christiana Dr, Newark", 
				"(123)-345-5678", "mas@yahoo.com");
		Student s9 = new Student("Isabelle", "Emma", "Hutchins", brdates.get(8), eMajor.CHEM, "5 South Chapel St, Newark", 
				"(302)-553-6185", "ieh@yahoo.com");
		Student s10 = new Student("Adam", "John", "Thorne", brdates.get(9), eMajor.COMPSI, "111 Christiana Dr, Newark", 
				"(123)-345-5678", "ajt@yahoo.com");
		
		ArrayList<Student> stList = new ArrayList<Student>();
		stList.add(s1);
		stList.add(s2);
		stList.add(s3);
		stList.add(s4);
		stList.add(s5);
		stList.add(s6);
		stList.add(s7);
		stList.add(s8);
		stList.add(s9);
		stList.add(s10);
		
		Student_Test.stList = stList;
	}

	@Test
	public void test() {
		ArrayList<Enrollment> enList = new ArrayList<Enrollment>(60);
		
		/*for(Enrollment e : enList)
			for(int i = 0; i < 6; i = i ++)
				for (int j = 0; j < 10; j++)
				{
					e = new Enrollment(secList.get(i).getSectionID(), stList.get(j).getStudentID());
					*/
		
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(0).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(1).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(2).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(3).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(4).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(5).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(6).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(7).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(8).getStudentID()));
		enList.add(new Enrollment(secList.get(0).getSectionID(), stList.get(9).getStudentID()));
		
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(0).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(1).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(2).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(3).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(4).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(5).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(6).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(7).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(8).getStudentID()));
		enList.add(new Enrollment(secList.get(1).getSectionID(), stList.get(9).getStudentID()));
		
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(0).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(1).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(2).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(3).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(4).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(5).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(6).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(7).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(8).getStudentID()));
		enList.add(new Enrollment(secList.get(2).getSectionID(), stList.get(9).getStudentID()));

		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(0).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(1).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(2).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(3).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(4).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(5).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(6).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(7).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(8).getStudentID()));
		enList.add(new Enrollment(secList.get(3).getSectionID(), stList.get(9).getStudentID()));
		
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(0).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(1).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(2).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(3).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(4).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(5).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(6).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(7).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(8).getStudentID()));
		enList.add(new Enrollment(secList.get(4).getSectionID(), stList.get(9).getStudentID()));
		
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(0).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(1).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(2).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(3).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(4).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(5).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(6).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(7).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(8).getStudentID()));
		enList.add(new Enrollment(secList.get(5).getSectionID(), stList.get(9).getStudentID()));
		
		
		
		enList.get(0).setGrade(3.0);
		enList.get(1).setGrade(3.5);
		enList.get(2).setGrade(4.0);
		enList.get(3).setGrade(3.0);
		enList.get(4).setGrade(2.0);
		enList.get(5).setGrade(1.0);
		enList.get(6).setGrade(3.5);
		enList.get(7).setGrade(2.0);
		enList.get(8).setGrade(1.0);
		enList.get(9).setGrade(3.5);
		
		enList.get(10).setGrade(3.0);
		enList.get(11).setGrade(3.5);
		enList.get(12).setGrade(4.0);
		enList.get(13).setGrade(3.0);
		enList.get(14).setGrade(2.0);
		enList.get(15).setGrade(1.0);
		enList.get(16).setGrade(3.5);
		enList.get(17).setGrade(2.0);
		enList.get(18).setGrade(1.0);
		enList.get(19).setGrade(3.5);
		
		enList.get(20).setGrade(3.0);
		enList.get(21).setGrade(3.5);
		enList.get(22).setGrade(4.0);
		enList.get(23).setGrade(3.0);
		enList.get(24).setGrade(2.0);
		enList.get(25).setGrade(1.0);
		enList.get(26).setGrade(3.5);
		enList.get(27).setGrade(2.0);
		enList.get(28).setGrade(1.0);
		enList.get(29).setGrade(3.5);
		
		enList.get(30).setGrade(3.0);
		enList.get(31).setGrade(3.5);
		enList.get(32).setGrade(4.0);
		enList.get(33).setGrade(3.0);
		enList.get(34).setGrade(2.0);
		enList.get(35).setGrade(1.0);
		enList.get(36).setGrade(3.5);
		enList.get(37).setGrade(2.0);
		enList.get(38).setGrade(1.0);
		enList.get(39).setGrade(3.5);
		
		enList.get(40).setGrade(3.0);
		enList.get(41).setGrade(3.5);
		enList.get(42).setGrade(4.0);
		enList.get(43).setGrade(3.0);
		enList.get(44).setGrade(2.0);
		enList.get(45).setGrade(1.0);
		enList.get(46).setGrade(3.5);
		enList.get(47).setGrade(2.0);
		enList.get(48).setGrade(1.0);
		enList.get(49).setGrade(3.5);
		
		enList.get(50).setGrade(3.0);
		enList.get(51).setGrade(3.5);
		enList.get(52).setGrade(4.0);
		enList.get(53).setGrade(3.0);
		enList.get(54).setGrade(2.0);
		enList.get(55).setGrade(1.0);
		enList.get(56).setGrade(3.5);
		enList.get(57).setGrade(2.0);
		enList.get(58).setGrade(1.0);
		enList.get(59).setGrade(3.5);
		
		double[] gradePoints = {3.0, 3.0, 4.0, 4.0, 4.0, 4.0};
		double sumGradePoints = 22.0;		
		double numerator = 0;
		int k = 0;
		double expectedList[] = { 3.0, 3.5, 4.0, 3.0, 2.0, 1.0, 3.5, 2.0, 1.0, 3.5};
		double gpa;
		//Checking each students GPA
		for(int j = 0; j < 10 ; j++) {
			k = 0;
			numerator = 0;
			for(int i = j; i < 60; i = i + 10) {
				numerator = numerator + enList.get(i).getGrade() * gradePoints[k];
				k++;
			}
			gpa = numerator/sumGradePoints;
			assertEquals(expectedList[j], gpa, 0.00001);
		}
		
		stList.get(0).setMajor(eMajor.BUSINESS);
	}
}