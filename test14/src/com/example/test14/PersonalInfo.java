package com.example.test14;

import java.util.Calendar;

public class PersonalInfo {
	private String name;
	private char gender;
	private int birthYear;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return (new java.util.GregorianCalendar()).get(Calendar.YEAR) 
					- birthYear;
	}
	
	public void setAge(int age) {
		birthYear = (new java.util.GregorianCalendar()).get(Calendar.YEAR)
					- age;
	}
}
