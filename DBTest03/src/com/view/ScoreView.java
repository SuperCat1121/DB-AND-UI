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
		System.out.println("���� ��ȸ �ý���...");
		System.out.print("1. ��ü��ȸ\t");
		System.out.println("2. ������ȸ");
		System.out.print("3. �߰� \t");
		System.out.print("4. ���� \t");
		System.out.println("5. ����");
		System.out.print("6. 1�� ��ȸ\t");
		System.out.print("7. 2�� ��ȸ\t");
		System.out.println("8. 3�� ��ȸ");
		System.out.println("9. �ý��� ����");
		System.out.println("�޴��� �����ϼ���");
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
				// ��ü ��ȸ
				List<ScoreDto> AllSelectDto = biz.AllSelect();
				for(ScoreDto dto : AllSelectDto) {
					System.out.println(dto);
				}
				break;
			case 2:
				// ���� ��ȸ
				System.out.println("��ȸ�� �̸��� �Է��ϼ��� : ");
				String TargetSname = sc.next();
				ScoreDto TargetSelectDto = biz.TargetSelect(TargetSname);
				System.out.println(TargetSelectDto);
				break;
			case 3:
				// �߰�
				System.out.println("�̸� : ");
				String insertSname = sc.next();
				System.out.println("�������� : ");
				int insertSkor = sc.nextInt();
				System.out.println("�������� : ");
				int insertSeng = sc.nextInt();
				System.out.println("�������� : ");
				int insertSmath = sc.nextInt();
				
				ScoreDto insertDto = new ScoreDto();
				insertDto.setSname(insertSname);
				insertDto.setSkor(insertSkor);
				insertDto.setSeng(insertSeng);
				insertDto.setSmath(insertSmath);
				int insertRes = biz.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("�߰� ����!");
				} else {
					System.out.println("�߰� ����..");
				}
				break;
			case 4:
				// ����
				System.out.println("������ �̸� : ");
				String updateSname = sc.next();
				System.out.println("������ �������� : ");
				int updateSkor = sc.nextInt();
				System.out.println("������ �������� : ");
				int updateSeng = sc.nextInt();
				System.out.println("������ �������� : ");
				int updateSmath = sc.nextInt();
				
				ScoreDto updateDto = new ScoreDto();
				updateDto.setSname(updateSname);
				updateDto.setSkor(updateSkor);
				updateDto.setSeng(updateSeng);
				updateDto.setSmath(updateSmath);
				int updateRes = biz.update(updateDto);
				if(updateRes > 0) {
					System.out.println("���� ����!");
				} else {
					System.out.println("���� ����..");
				}
				break;
			case 5:
				// ����
				System.out.println("������ �̸� �Է� : ");
				String deleteSname = sc.next();
				int deleteRes = biz.delete(deleteSname);
				if(deleteRes > 0) {
					System.out.println("���� ����!");
				} else {
					System.out.println("���� ����..");
				}
				break;
			case 6:
				// 1�� ��ȸ
				System.out.println("****** 1���� ���� : ");
				rankDto = biz.rankSelect(1);
				System.out.println(rankDto);
				break;
			case 7:
				// 2�� ��ȸ
				System.out.println("****** 2���� ���� : ");
				rankDto = biz.rankSelect(2);
				System.out.println(rankDto);
				break;
			case 8:
				// 3�� ��ȸ
				System.out.println("****** 3���� ���� : ");
				rankDto = biz.rankSelect(3);
				System.out.println(rankDto);
				break;
			case 9:
				// ����
				System.out.println("�����մϴ�..");
				break;
			}
		} while (select != 9);
	}
}





























