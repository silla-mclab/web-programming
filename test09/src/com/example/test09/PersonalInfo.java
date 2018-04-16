package com.example.test09;

public class PersonalInfo {
	private String name;
	private String id;
	private String passwd;
	private char gender;		// 'M', 'F'
	private boolean inotice;
	private boolean cnotice;
	private boolean dnotice;
	private String job;
	private String intro;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public boolean isInotice() {
		return inotice;
	}
	public void setInotice(boolean inotice) {
		this.inotice = inotice;
	}
	public boolean isCnotice() {
		return cnotice;
	}
	public void setCnotice(boolean cnotice) {
		this.cnotice = cnotice;
	}
	public boolean isDnotice() {
		return dnotice;
	}
	public void setDnotice(boolean dnotice) {
		this.dnotice = dnotice;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
}
