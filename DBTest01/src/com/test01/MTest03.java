package com.test01;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest03 {
	
	public static void main(String[] args) {
		// MYTEST ���̺� ��ȣ, �̸�, ������ INSERT
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȣ : ");
		int mno = sc.nextInt();
		System.out.println("�̸� : ");
		String mname = sc.next();
		System.out.println("���� : ");
		String nickname = sc.next();
		
		Connection con = getConnection();
		Statement stmt = null;
		//ResultSet rs = null;
		int res = 0;
		
		String sql = "INSERT INTO MYTEST" +
		              " VALUES( " + mno + ", '" + mname + "','"
		              + nickname + "')";
		
		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			if(res > 0) {
				commit(con);
				System.out.println("insert ����!");
			} else {
				System.out.println("insert ����!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(stmt);
		close(con);
		sc.close();
	}
}

















