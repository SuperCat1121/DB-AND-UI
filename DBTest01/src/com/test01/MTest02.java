package com.test01;

import java.sql.*;

public class MTest02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// SELECT * FROM DEPT;
		// 1. driver ���� : ojdbc6.jar
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. ���� ����
		Connection con = null;
		String url ="jdbc:oracle:thin:@localhost:1521:XE";
		String user ="kh";
		String password = "kh";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3. query �غ�
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM DEPT ";
		// 4. query ���� �� ��� ����
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.printf("%d \t %10s \t %s \n", rs.getInt(1),
								rs.getString(2), rs.getString(3));
		}
		// 5. db ����
		rs.close();
		stmt.close();
		con.close();
	}

}
