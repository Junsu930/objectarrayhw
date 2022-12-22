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
			case 3: updateMember(); break;
 			case 4: deleteMember(); break;
			case 5: printAllMember(); break;
			case 6: sortMember(); break;
			default: System.out.println("잘못 입력하셨습니다."); break; 
			}
		}while(input != 0);
		
	}
	
	public void insertMember() {
		System.out.println("현재 회원 : "+ mc.getMemberCount());
		//1) 현재 회원 수가 최대 회원수를 넘어가면 return 처리
		if(mc.getMemberCount()>9) {
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
			if(input != 9) {
			
				System.out.print("검색 내용 : ");
				inputtext = sc.next();
				if(mc.searchMember(input, inputtext)!= null){
					//찾는 값이 null이 아니면 정보 출력
					System.out.println(mc.searchMember(input, inputtext).information());
					
				}else{
				
					System.out.println("검색된 결과가 없습니다.");
				};
			}
		}while(input != 9);
		
		mainMenu(); 
	}

	public void updateMember() {
		
		int input = 9;
		
		do {
			System.out.println("===== 회원 정보 수정 ======");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴 선택 : ");
			//메뉴 설정
			input = sc.nextInt();
			if(input != 9) {
				System.out.print("변경할 회원 아이디 : ");
				String userId = sc.next();
			//9를 입력하지 않으면 아이디를 받는다
				if( mc.checkId(userId)==null) {
					// checkId()메소드 사용 결과값 받는다.
					System.out.println("변경할 회원이 존재하지 않습니다.");
				}else if(input == 1){ 
					//기존 정보 출력
					System.out.println(mc.checkId(userId).information());
					System.out.print("비밀번호를 입력하세요 : ");
					//비밀번호 확인 과정을 넣는다.
					String pw = sc.next();
					if(pw.equals(mc.checkId(userId).getUserPw())) {
						System.out.print("변경할 비밀번호를 입력하세요 : ");
						String pw2 = sc.next();
						System.out.print("변경할 비밀번호를 다시 입력하세요 : ");
						String pw3 = sc.next();
						if(pw2.equals(pw3)){
							mc.updateMember(mc.checkId(userId), input, pw2);
						}else {
							System.out.println("수정할 비밀번호가 일치하지 않습니다.");
						}
					} else {
						System.out.println("비밀번호가 다릅니다.");
					}
					// 비밀번호 수정 코드 완료
				}else if(input ==2) {
					// 이름 수정
					System.out.println(mc.checkId(userId).information());
					System.out.print("비밀번호를 입력하세요 : ");
					//비밀번호 확인 과정을 넣는다.
					String pw = sc.next();
					if(pw.equals(mc.checkId(userId).getUserPw())) {
						System.out.print("변경할 이름을 입력하세요 : ");
						String nameedit = sc.next();
						mc.updateMember(mc.checkId(userId), input, nameedit);
					}else {
						System.out.println("비밀번호가 다릅니다.");
					}
				}else if(input == 3) {
					System.out.println(mc.checkId(userId).information());
					System.out.print("비밀번호를 입력하세요 : ");
					//비밀번호 확인 과정을 넣는다.
					String pw = sc.next();
					if(pw.equals(mc.checkId(userId).getUserPw())) {
						System.out.print("변경할 이메일을 입력하세요 : ");
						String emailedit = sc.next();
						mc.updateMember(mc.checkId(userId), input, emailedit);
					}else {
						System.out.println("비밀번호가 다릅니다.");
					}
				}
			};
			
		}while(input != 9);
		mainMenu();
	}
	
	public void deleteMember() {
		
		System.out.print("삭제할 아이디를 입력하세요 : ");
		String deId = sc.next();
		
		//삭제할 아이디 받음
		
		if(mc.checkId(deId) == null) {
			System.out.println("삭제할 회원이 존재하지 않습니다.");
		}else {
			System.out.println(mc.checkId(deId).information());
			//정보 출력
			System.out.print("정말 삭제하시겠습니까 ? (Y/N)");
			char yon = sc.next().charAt(0);
			// yes or no 입력받음
			if(yon == 'y' || yon == 'Y') {
				mc.deleteMember(deId);
				//진짜 삭제 원할시
			}
		}
	}
	
	public void printAllMember() {
		
		for(int i = 0; i<mc.getMemberCount(); i++) {
			 System.out.println( mc.getMem()[i].information()) ;
		}
		
	}
	
	public void sortMember() {
		
		Member[] sortMem = null;
		int input = 0;
		
		do {
			System.out.println("=====회원 정보 정렬=====");
			System.out.println("1. 아이디 오름차순 정렬");
			System.out.println("2. 아이디 내림차순 정렬");
			System.out.println("3. 나이 오름차순 정렬");
			System.out.println("4. 나이 내림차순 정렬");
			System.out.println("5. 성별 남/여 순 정렬");
			System.out.println("9. 이전 메뉴료");
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: System.out.println("정렬 완료"); sortMem=mc.sortIdAsc(); break;
			case 2:
			case 3:
			case 4:
			case 5:
			}
		}while(input != 9);{
			mainMenu();
		}
		
		mc.setMem(sortMem);
	}
	
}
