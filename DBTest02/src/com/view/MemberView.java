package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

public class MemberView {

	static Scanner sc = new Scanner(System.in);
	
	
	public static int getMenu() {
		int selectNum = 0;
		System.out.println("1. 전체출력");
		System.out.println("2. 선택출력");
		System.out.println("3. 추    가");
		System.out.println("4. 수    정");
		System.out.println("5. 삭    제");
		System.out.println("6. 종    료");
		System.out.println("번호 선택 : ");
		selectNum = sc.nextInt();
		
		return selectNum;
	}
	
	public static void main(String[] args) {
		MemberBiz biz = new MemberBizImpl();
		int no = 0;
		
		do {
			no = getMenu();
			switch(no) {
			case 1:
				System.out.println("****전체 출력****");
				List<MemberDto> list = biz.selectList();
				for(MemberDto dto : list) {
					System.out.println(dto);
				}
				break;
			case 2:
				System.out.println("출력할 번호 입력 : ");
				int m_no = sc.nextInt();
				MemberDto dto = biz.selectOne(m_no);
				System.out.println(dto);
				break;
			case 3:
				// 추가
				System.out.println("추가할 이름 : ");
				String m_name = sc.next();
				System.out.println("나이 : ");
				int m_age = sc.nextInt();
				System.out.println("성별(M/F) : ");
				String m_gender = sc.next();
				System.out.println("지역 : ");
				String m_location = sc.next();
				System.out.println("직업 : ");
				String m_job = sc.next();
				System.out.println("전화번호 : ");
				String m_tel = sc.next();
				System.out.println("이메일 : ");
				String m_email = sc.next();
				MemberDto insertDto = new MemberDto();
				insertDto.setM_name(m_name);
				insertDto.setM_age(m_age);
				insertDto.setM_gender(m_gender);
				insertDto.setM_location(m_location);
				insertDto.setM_job(m_job);
				insertDto.setM_tel(m_tel);
				insertDto.setM_email(m_email);
				int insertRes = biz.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("insert 성공!");
				} else {
					System.out.println("insert 실패..");
				}
				break;
			case 4:
				// 수정
				System.out.println("수정할 번호 입력 : ");
				int updateM_no = sc.nextInt();
				System.out.println("수정할 이름 입력 : ");
				String updateM_name = sc.next();
				System.out.println("수정할 나이 입력 : ");
				int updateM_age = sc.nextInt();
				System.out.println("수정할 성별(M/F) 입력 : ");
				String updateM_gender = sc.next();
				System.out.println("수정할 위치 입력 : ");
				String updateM_location = sc.next();
				System.out.println("수정할 직무 입력 : ");
				String updateM_job = sc.next();
				System.out.println("수정할 전화번호 입력 : ");
				String updateM_tel = sc.next();
				System.out.println("수정할 이메일 입력 : ");
				String updateM_email = sc.next();
				
				MemberDto updateDto = new MemberDto();
				updateDto.setM_no(updateM_no);
				updateDto.setM_name(updateM_name);
				updateDto.setM_age(updateM_age);
				updateDto.setM_gender(updateM_gender);
				updateDto.setM_location(updateM_location);
				updateDto.setM_job(updateM_job);
				updateDto.setM_tel(updateM_tel);
				updateDto.setM_email(updateM_email);
				biz.update(updateDto);
				break;
			case 5:
				// 삭제
				System.out.println("삭제할 번호 입력 : ");
				int deleteM_no = sc.nextInt();
				biz.delete(deleteM_no);
				break;
			case 6:
				// 종료
				System.out.println("종료합니다...");
				sc.close();
				break;
			}
		}while(no != 6);
	}
}
