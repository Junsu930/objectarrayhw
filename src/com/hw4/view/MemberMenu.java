package com.hw4.view;

import java.util.Scanner;

import com.hw4.controller.MemberController;
import com.hw4.model.vo.Member;

public class MemberMenu {
	
	MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		int input = 0;

		do {
			System.out.println("==== 회원 관리 메뉴 ====");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 실행 > ");
			input = sc.nextInt();
			switch(input) {
			case 1: insertMember(); break;
			case 2: searchMember(); break;
			case 3:
			case 4:
			case 5:
			case 6:
			default: System.out.println("잘못 입력하셨습니다."); break; 
			}
		}while(input != 0);
		
	}
	
	public void insertMember() {
		
		//1) 현재 회원 수가 최대 회원수를 넘어가면 return 처리
		if(mc.getMemberCount()>10) {
			return;
		}else {
			//2) 아이디를 입력받아서 결과값 전달
			System.out.print("아이디를 입력하세요 : ");
			String id = sc.next();
			if(mc.checkId(id) != null) {
				System.out.println("동일한 아이디가 존재합니다. 회원 등록 실패");
			}else {
				System.out.print("비밀번호를 입력하세요 : ");
				String pw = sc.next();
				System.out.print("이름 입력하세요 : ");
				String name = sc.next();
				System.out.print("나이를 입력하세요 : ");
				int age = sc.nextInt();
				System.out.print("성별을 입력하세요 : (M/F)");
				char gender = sc.next().charAt(0);
				System.out.println("이메일을 입력하세요 : ");
				String email = sc.next();
				
				Member member  = new Member(id, pw, name, age, gender, email);	
				
				mc.insertMember(member);
				// 3)등록 완료
				System.out.println("성공적으로 회원 등록이 되었습니다.");
				
			}
		}
		
	}
	
	public void searchMember() {
		int input =9;
		String inputtext;
		do {
			System.out.println("===== 회원 정보 검색 =====");
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			// 메뉴 입력받고 검색 내용 출력
			System.out.print("검색 내용 : ");
			inputtext = sc.next();
			
			mc.searchMember(input, inputtext).information();
			
			
		}while(input != 9);
		mainMenu();
	}

	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}
	
	public void printAllMember() {
		
	}
	
	public void sortMember() {
		
	}
}
