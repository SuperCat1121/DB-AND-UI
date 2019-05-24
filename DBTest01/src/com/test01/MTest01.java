package com.test01;

import java.sql.*;

public class MTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection con = 
				DriverManager.getConnection(url,"kh","kh");
		// 3. query 준비
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		// 4. query 실행 및 결과 리턴
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.printf("%d \t %10s \t %10s \t %d \t %s \t %4.2f \t %f \t %d \n",
					rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getInt(4), rs.getDate(5), rs.getDouble(6),
					rs.getDouble("COMM"), rs.getInt(8));
		}
		// 5. db 종료
		rs.close();
		stmt.close();
		con.close();
	}
}





















