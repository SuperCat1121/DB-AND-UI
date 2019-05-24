package com.test01;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MTest06 {

	public static void main(String[] args) {
		// DELETE FROM MYTEST WHERE MNO=?
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 회원번호 : ");
		int mno = sc.nextInt();fdgdfg
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "DELETE FROM MYTEST WHERE MNO=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			res = pstmt.executeUpdate();
			if(res > 0) {
				commit(con);
				System.out.println("Delete 성공!");
			} else {
				System.out.println("Delete 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
			sc.close();
		}
	}
	
}
