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
		
		sb.append("1. ��ü���\n")
		  .append("2. ��      ��\n")
		  .append("3. ��      ��\n")
		  .append("4. ��      ��\n")
		  .append("5. �������\n")
		  .append("6. ��      ��\n");
		System.out.println(sb);
		System.out.println("��ȣ ���� : ");
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
				// ��ü ���
				List<MyTestDto> list = dao.selectList();
				for(MyTestDto dto : list) {
					System.out.printf("%d\t%s\t%s\t\n", dto.getMno(), dto.getMname(), dto.getNickname());
				}
				break;
			case 2:
				// �߰�
				int insertMno;
				String insertMname;
				String insertNickname;
				System.out.println("�߰��� ��ȣ : ");
				insertMno = sc.nextInt();
				System.out.println("�߰��� �̸� : ");
				insertMname = sc.next();
				System.out.println("�߰��� ���� : ");
				insertNickname = sc.next();
				
				MyTestDto insertDto = new MyTestDto(insertMno, insertMname, insertNickname);
				
				int insertRes = dao.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("�߰� ����!");
				} else {
					System.out.println("�߰� ����!");
				}
				break;
			case 3:
				//����
				int updateMno;
				String updateMname;
				String updateNickname;
				System.out.println("������ ��ȣ : ");
				updateMno = sc.nextInt();
				System.out.println("������ �̸� : ");
				updateMname = sc.next();
				System.out.println("������ ���� : ");
				updateNickname = sc.next();
				
				MyTestDto updateDto = new MyTestDto(updateMno, updateMname, updateNickname);
				int updateRes = dao.update(updateDto);
				if(updateRes > 0) {
					System.out.println("���� ����!");
				} else {
					System.out.println("���� ����!");
				}
				break;
			case 4:
				// ����
				System.out.println("������ ��ȣ : ");
				int deleteMno = sc.nextInt();
				int deleteRes = dao.delete(deleteMno);
				if(deleteRes > 0) {
					System.out.println("���� ����!");
				} else {
					System.out.println("���� ����!");
				}
				break;
			case 5:
				// ���� ���
				System.out.println("��ȸ�� ��ȣ");
				int selectMno = sc.nextInt();
				MyTestDto tSelect = dao.tSelect(selectMno);
				System.out.printf("%d\t%s\t%s\n", tSelect.getMno(),
						tSelect.getMname(), tSelect.getNickname());
				break;
			case 6:
				// ����
				System.out.println("����Ǿ����ϴ�");
				break;
			}
		}while(no != 6);
		
		
	}
	
}


















