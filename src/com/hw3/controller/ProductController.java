package com.hw3.controller;

import java.util.Scanner;

import com.hw3.moderl.vo.Product;

public class ProductController {

	Scanner sc = new Scanner(System.in);
	
	private Product[] pro= new Product[10];

	
	public int count=0;
	int button= 0;
	
	public void mainMenu() {
		do {
		
			System.out.println("=====제품 관리 메뉴=====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 > ");
			button = sc.nextInt();
			
			if(button == 1) {
				productInput();
				
			}else if (button==2) {
				if(count!=0) {
					productPrint();	
				}else System.out.println("제품이 없습니다.");
				
			}else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
			
			
		}while(button != 0);
		System.out.println("프로그램을 종료합니다.");
		
	}
	
	public void productInput() {
		
		System.out.println("현재 추가된 도서 : "+count);

		if(count<10) {
			System.out.print("제품 번호 : ");
			int pId = sc.nextInt();
			sc.nextLine();
			System.out.print("제품명 : ");
			String pName = sc.nextLine();
			System.out.print("제품 가격 : ");
			int price = sc.nextInt();
			System.out.print("제품 세금 : ");
			double tax = sc.nextDouble();
			
			pro[count] = new Product(pId, pName, price, tax);
			count++;
			System.out.println("등록 완료");
		} else {
			System.out.println("도서 등록 실패(초과)");
		}
		
	}
	
	public void productPrint() {
		
		for(int i=0; i<count; i++) {
			System.out.println();
			System.out.println(i+1 + "번 째 도서");
			System.out.println(pro[i].information());
			
		}
		
		
	}



}
