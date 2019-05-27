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
		System.out.println("1. ��ü���");
		System.out.println("2. �������");
		System.out.println("3. ��    ��");
		System.out.println("4. ��    ��");
		System.out.println("5. ��    ��");
		System.out.println("6. ��    ��");
		System.out.println("��ȣ ���� : ");
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
				System.out.println("****��ü ���****");
				List<MemberDto> list = biz.selectList();
				for(MemberDto dto : list) {
					System.out.println(dto);
				}
				break;
			case 2:
				System.out.println("����� ��ȣ �Է� : ");
				int m_no = sc.nextInt();
				MemberDto dto = biz.selectOne(m_no);
				System.out.println(dto);
				break;
			case 3:
				// �߰�
				System.out.println("�߰��� �̸� : ");
				String m_name = sc.next();
				System.out.println("���� : ");
				int m_age = sc.nextInt();
				System.out.println("����(M/F) : ");
				String m_gender = sc.next();
				System.out.println("���� : ");
				String m_location = sc.next();
				System.out.println("���� : ");
				String m_job = sc.next();
				System.out.println("��ȭ��ȣ : ");
				String m_tel = sc.next();
				System.out.println("�̸��� : ");
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
					System.out.println("insert ����!");
				} else {
					System.out.println("insert ����..");
				}
				break;
			case 4:
				// ����
				System.out.println("������ ��ȣ �Է� : ");
				int updateM_no = sc.nextInt();
				System.out.println("������ �̸� �Է� : ");
				String updateM_name = sc.next();
				System.out.println("������ ���� �Է� : ");
				int updateM_age = sc.nextInt();
				System.out.println("������ ����(M/F) �Է� : ");
				String updateM_gender = sc.next();
				System.out.println("������ ��ġ �Է� : ");
				String updateM_location = sc.next();
				System.out.println("������ ���� �Է� : ");
				String updateM_job = sc.next();
				System.out.println("������ ��ȭ��ȣ �Է� : ");
				String updateM_tel = sc.next();
				System.out.println("������ �̸��� �Է� : ");
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
				// ����
				System.out.println("������ ��ȣ �Է� : ");
				int deleteM_no = sc.nextInt();
				biz.delete(deleteM_no);
				break;
			case 6:
				// ����
				System.out.println("�����մϴ�...");
				sc.close();
				break;
			}
		}while(no != 6);
	}
}
