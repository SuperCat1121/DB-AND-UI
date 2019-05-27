package com.view;

import java.util.List;
import java.util.Scanner;

import com.dao.MyTestDao;
import com.dto.MyTestDto;

public class MyTestView {

	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		StringBuffer sb = new StringBuffer();
		
		sb.append("1. 전체출력\n")
		  .append("2. 추      가\n")
		  .append("3. 수      정\n")
		  .append("4. 삭      제\n")
		  .append("5. 선택출력\n")
		  .append("6. 종      료\n");
		System.out.println(sb);
		System.out.println("번호 선택 : ");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int no = 0;
		MyTestDao dao = new MyTestDao();
		do {
			no = getMenu();
			switch(no) {
			case 1:
				// 전체 출력
				List<MyTestDto> list = dao.selectList();
				for(MyTestDto dto : list) {
					System.out.printf("%d\t%s\t%s\t\n", dto.getMno(), dto.getMname(), dto.getNickname());
				}
				break;
			case 2:
				// 추가
				int insertMno;
				String insertMname;
				String insertNickname;
				System.out.println("추가할 번호 : ");
				insertMno = sc.nextInt();
				System.out.println("추가할 이름 : ");
				insertMname = sc.next();
				System.out.println("추가할 별명 : ");
				insertNickname = sc.next();
				
				MyTestDto insertDto = new MyTestDto(insertMno, insertMname, insertNickname);
				
				int insertRes = dao.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("추가 성공!");
				} else {
					System.out.println("추가 실패!");
				}
				break;
			case 3:
				//수정
				int updateMno;
				String updateMname;
				String updateNickname;
				System.out.println("변경할 번호 : ");
				updateMno = sc.nextInt();
				System.out.println("변경할 이름 : ");
				updateMname = sc.next();
				System.out.println("변경할 별명 : ");
				updateNickname = sc.next();
				
				MyTestDto updateDto = new MyTestDto(updateMno, updateMname, updateNickname);
				int updateRes = dao.update(updateDto);
				if(updateRes > 0) {
					System.out.println("수정 성공!");
				} else {
					System.out.println("수정 실패!");
				}
				break;
			case 4:
				// 삭제
				System.out.println("삭제할 번호 : ");
				int deleteMno = sc.nextInt();
				int deleteRes = dao.delete(deleteMno);
				if(deleteRes > 0) {
					System.out.println("삭제 성공!");
				} else {
					System.out.println("삭제 실패!");
				}
				break;
			case 5:
				// 선택 출력
				System.out.println("조회할 번호");
				int selectMno = sc.nextInt();
				MyTestDto tSelect = dao.tSelect(selectMno);
				System.out.printf("%d\t%s\t%s\n", tSelect.getMno(),
						tSelect.getMname(), tSelect.getNickname());
				break;
			case 6:
				// 종료
				System.out.println("종료되었습니다");
				break;
			}
		}while(no != 6);
		
		
	}
	
}


















