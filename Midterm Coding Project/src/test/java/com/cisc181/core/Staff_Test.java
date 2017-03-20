package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void test() {
		ArrayList<Staff> list =  new ArrayList<Staff>(5);
		ArrayList<String> bDateStr = new ArrayList<String>(5);
		ArrayList<String> hDateStr = new ArrayList<String>(5);
		ArrayList<Date> bDates = new ArrayList<Date>(5);
		ArrayList<Date> hDates = new ArrayList<Date>(5);
		
		bDateStr.add("07/31/1983");
		bDateStr.add("01/28/1957");
		bDateStr.add("05/19/1994");
		bDateStr.add("08/29/1966");
		bDateStr.add("02/06/1969");
		
		hDateStr.add("05/25/2002");
		hDateStr.add("02/18/2014");
		hDateStr.add("08/30/2010");
		hDateStr.add("07/16/2007");
		hDateStr.add("09/29/2008");

		String formatDate = "mm/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(formatDate);
		Date bDate = null;
		Date hDate = null;
		
		for (String bd : bDateStr)
			try {
				bDate = format.parse(bd);
				bDates.add(bDate);
			} catch (ParseException e) {
				System.out.println("Date Formatted incorrectly");
			}
		
		for (String hd : hDateStr)
			try {
				hDate = format.parse(hd);
				hDates.add(hDate);
			} catch (ParseException e) {
				System.out.println("Date Formatted incorrectly");
			}

		/*String bd = "07/31/1983";
		
		try {
			bDate = format.parse(bd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}

		String hd = "05/30/2003";
		Date hDate = null;
		try {
			hDate = format.parse(hd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}*/

		Staff s1 = new Staff("Harry", "James", "Potter", bDates.get(0) , "4 Privet Drive, Surrey", 
				"(123)-345-5678", "hp@hogwarts.com", "1-5", 3, 12000, hDates.get(0) , eTitle.MR);
		Staff s2 = new Staff("Brian", "Percy", "Ruckler", bDates.get(1) , "5 South Chapel St, Newark", 
				"(925)-384-9070", "bpr@gmail.com", "8-12", 4, 10000, hDates.get(1) , eTitle.MR);
		Staff s3 = new Staff("Emma", "Marie", "Sills", bDates.get(2) , "230 E Main St, Newark", 
				"(971)-227-8140", "ems@yahoo.com", "1-5", 2, 15000, hDates.get(2) , eTitle.MS);
		Staff s4 = new Staff("Sofia", "Victory", "Chase", bDates.get(3) , "218 Ayrshire Farm Ln, Stanford", 
				"(457)-355-2747", "svc@gmail.com", "5-9", 1, 20000, hDates.get(3) , eTitle.MS);
		Staff s5 = new Staff("Annabeth", "Pearl", "Jackson", bDates.get(4) , "111 Christiana Dr, Newark", 
				"(302)-553-6185", "apj@hotmail.com", "5-9", 1, 20000, hDates.get(4) , eTitle.MRS);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		double sum = 0;
		for(Staff s: list) {
			sum = sum + s.getSalary();
		}
		double avgSal = sum/5.0; 
		
		assertEquals(15400.00, avgSal, 0.001);	
	}	
	
	@Test(expected = PersonException.class)
	public void testBirthDateException() throws PersonException {
		
		String formatDate = "mm/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(formatDate);
		Date bDate = null;
		Date hDate = null;
		
		String bd = "07/31/1999";
		
		try {
			bDate = format.parse(bd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}

		String hd = "05/30/2003";
		try {
			hDate = format.parse(hd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}
		
		Staff s1 = new Staff("Harry", "James", "Potter", bDate, "4 Privet Drive, Surrey", 
				"(123)-345-5678", "hp@hogwarts.com", "1-5", 3, 12000, hDate, eTitle.MR);
		
		bd = "07/31/1900";
		
		try {
			bDate = format.parse(bd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}
		
		s1.setDOB(bDate);
	}

	
	@Test(expected = PersonException.class)
	public void testPhoneNumbers() throws PersonException{
		
		String formatDate = "mm/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(formatDate);
		Date bDate = null;
		Date hDate = null;
		
		String bd = "07/31/1999";
		
		try {
			bDate = format.parse(bd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}

		String hd = "05/30/2003";
		try {
			hDate = format.parse(hd);
		} catch (ParseException e) {
			System.out.println("Date Formatted incorrectly");
		}
		Staff s1 = new Staff("Harry", "James", "Potter", bDate, "4 Privet Drive, Surrey", 
				"(123)-345-5678", "hp@hogwarts.com", "1-5", 3, 12000, hDate, eTitle.MR);
		
		s1.setPhone("123-456-7890");

	}
}
