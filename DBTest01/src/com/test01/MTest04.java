package com.test01;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest04 {
	
	// UPDATE MYTEST SET MNAME = '', NICKNAME = '' WHERE MNO = '';
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 번호 : ");
		int mno = sc.nextInt();
		System.out.println("변경할이름 : ");
		String mname = sc.next();
		System.out.println("변경할별명 : ");
		String nickname = sc.next();
		
		Connection con = getConnection();
		Statement stmt = null;
		int res;
		
		String sql = "UPDATE MYTEST SET MNAME='" + mname + "', NICKNAME='" +
								 nickname + "' WHERE MNO=" + mno;
		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			if(res > 0) {
				commit(con);
				System.out.println("update 성공!");
			} else {
				System.out.println("update 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(stmt);
		close(con);
		sc.close();
	}
}
