package com.test01;

import static common.JDBCTemplate.*;

import java.sql.*;
import java.util.Scanner;

public class MTest05 {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 회원번호 : ");
		int mno = sc.nextInt();

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MYTEST WHERE MNO=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			System.out.println(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while(rs.next()) {
			System.out.printf("%d \t %s \t %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		close(rs);
		close(pstmt);
		close(con);
		sc.close();
	}

}
