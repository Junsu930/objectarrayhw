package com.hw4.controller;

import com.hw4.model.vo.Member;

public class MemberController {
	
	public static final int SIZE = 10;
	private int memberCount;
	
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	private Member[] mem = new Member[SIZE];
	
	{
	mem[0] = new Member("user01", "pass01", "김유신", 20, 'M'
			, "kim12@naver.com");
	mem[1] = new Member("user02", "pass02", "이순신", 60, 'M'
			, "lee2@naver.com");
	mem[2] = new Member("user03", "pass03", "유관순", 17, 'F'
			, "yo5@hanmail.com");
	mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M'
			, "yeon@gmail.com");
	mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F'
			, "shim@naver.com");
	memberCount = 5;
	}
	
	public int getMemberCount() {
		return memberCount;
	}

	public Member[] getMem() {
		return mem;
	}

	public Member checkId(String userId) {
		Member m = null;
		for(int i=0; i<memberCount; i++) {
			if(mem[i].getUserId()== userId) {
				m = mem[i];
			}
		}
		return m;
		
	}
	
	public void insertMember(Member m) {
		
	}
	
	
	public Member searchMember(int menu, String search) {
		
		Member searchMember = null; //검색된 회원 담을 변수 초기화
		
		switch(menu) {
		case 1: for(int i = 0; i<memberCount; i++) {
			if(mem[i].getUserId().equals(search)) {
				searchMember = mem[i];
			}
		}
		case 2: for(int i = 0; i<memberCount; i++) {
			if(mem[i].getName().equals(search)) {
				searchMember = mem[i];
			}
		}
		case 3: for(int i = 0; i<memberCount; i++) {
			if(mem[i].getEmail().equals(search)) {
				searchMember = mem[i];
			}
		}//검색 후 주소값 리턴
		return searchMember;
		}
		
	}
	 
	
	public void updateMember(Member m, int menu, String update) {
		
	}
	
	public void deleteMember(String userId) {
		
	}
	/*
	public Member[] sortIdAsc() {
		
	}
	
	public Member[] sortIdDesc() {
		
	}
	
	public Member[] sortAgeAsc() {
		
	}
	public Member[] sortAgeDesc() {
		
	}
	
	public Member[] sortGenderDesc() {
		
	}
	*/
}
