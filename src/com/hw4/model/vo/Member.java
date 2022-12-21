package com.hw4.model.vo;

public class Member {
	private String userId;
	private String userPw;
	private String name;
	private int age;
	private char gender;
	private String email;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Member() {}
	public Member(String userId, String userPw, String name, int age, char gender, String email) {
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}
	
	public String information() {
		return"ID : " + userId + "\n이름 : " + name + 
				"\n 나이 : " + age + "\n 성별 : " + gender 
				+ "\n 이메일 : " + email;
	}
	

}
