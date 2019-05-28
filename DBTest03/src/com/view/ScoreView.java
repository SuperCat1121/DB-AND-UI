package com.view;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Scanner;

import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;
import com.dto.ScoreDto;

public class ScoreView {

	static Scanner sc = new Scanner(System.in);
	
	public static int getScoreMenu() {
		System.out.println("성적 조회 시스템...");
		System.out.print("1. 전체조회\t");
		System.out.println("2. 선택조회");
		System.out.print("3. 추가 \t");
		System.out.print("4. 수정 \t");
		System.out.println("5. 삭제");
		System.out.print("6. 1등 조회\t");
		System.out.print("7. 2등 조회\t");
		System.out.println("8. 3등 조회");
		System.out.println("9. 시스템 종료");
		System.out.println("메뉴를 선택하세요");
		int select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		ScoreBiz biz = new ScoreBizImpl();
		ScoreDto rankDto = new ScoreDto();
		int select = 0;
		do {
			select = getScoreMenu();
			switch (select) {
			case 1:
				// 전체 조회
				List<ScoreDto> AllSelectDto = biz.AllSelect();
				for(ScoreDto dto : AllSelectDto) {
					System.out.println(dto);
				}
				break;
			case 2:
				// 선택 조회
				System.out.println("조회할 이름을 입력하세요 : ");
				String TargetSname = sc.next();
				ScoreDto TargetSelectDto = biz.TargetSelect(TargetSname);
				System.out.println(TargetSelectDto);
				break;
			case 3:
				// 추가
				System.out.println("이름 : ");
				String insertSname = sc.next();
				System.out.println("국어점수 : ");
				int insertSkor = sc.nextInt();
				System.out.println("영어점수 : ");
				int insertSeng = sc.nextInt();
				System.out.println("수학점수 : ");
				int insertSmath = sc.nextInt();
				
				ScoreDto insertDto = new ScoreDto();
				insertDto.setSname(insertSname);
				insertDto.setSkor(insertSkor);
				insertDto.setSeng(insertSeng);
				insertDto.setSmath(insertSmath);
				int insertRes = biz.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("추가 성공!");
				} else {
					System.out.println("추가 실패..");
				}
				break;
			case 4:
				// 수정
				System.out.println("수정할 이름 : ");
				String updateSname = sc.next();
				System.out.println("수정할 국어점수 : ");
				int updateSkor = sc.nextInt();
				System.out.println("수정할 영어점수 : ");
				int updateSeng = sc.nextInt();
				System.out.println("수정할 수학점수 : ");
				int updateSmath = sc.nextInt();
				
				ScoreDto updateDto = new ScoreDto();
				updateDto.setSname(updateSname);
				updateDto.setSkor(updateSkor);
				updateDto.setSeng(updateSeng);
				updateDto.setSmath(updateSmath);
				int updateRes = biz.update(updateDto);
				if(updateRes > 0) {
					System.out.println("수정 성공!");
				} else {
					System.out.println("수정 실패..");
				}
				break;
			case 5:
				// 삭제
				System.out.println("삭제할 이름 입력 : ");
				String deleteSname = sc.next();
				int deleteRes = biz.delete(deleteSname);
				if(deleteRes > 0) {
					System.out.println("삭제 성공!");
				} else {
					System.out.println("삭제 실패..");
				}
				break;
			case 6:
				// 1등 조회
				System.out.println("****** 1등의 정보 : ");
				rankDto = biz.rankSelect(1);
				System.out.println(rankDto);
				break;
			case 7:
				// 2등 조회
				System.out.println("****** 2등의 정보 : ");
				rankDto = biz.rankSelect(2);
				System.out.println(rankDto);
				break;
			case 8:
				// 3등 조회
				System.out.println("****** 3등의 정보 : ");
				rankDto = biz.rankSelect(3);
				System.out.println(rankDto);
				break;
			case 9:
				// 종료
				System.out.println("종료합니다..");
				break;
			}
		} while (select != 9);
	}
}





























