package com.dao;

import static common.JDBCTemplate.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dto.MyTestDto;

// DAO : Data Access Object
// DB와 접속만 한다
public class MyTestDao {

	public List<MyTestDto> selectList() {
		// 1. driver 연결, 2. 계정 연결
		Connection con = getConnection();
		
		// 3. query 준비
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MYTEST ORDER BY MNO";
		List<MyTestDto> list = new ArrayList<MyTestDto>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MyTestDto dto = new MyTestDto();
				dto.setMno(rs.getInt(1));
				dto.setMname(rs.getString(2));
				dto.setNickname(rs.getString(3));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		return list;
	}

	
	public int insert(MyTestDto dto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MYTEST VALUES(?, ?, ?)";
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMno());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getNickname());
			res = pstmt.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return res;
	}
	
	public int update(MyTestDto dto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE MYTEST SET MNAME=?, NICKNAME=? "
				+ "WHERE MNO=?";
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getNickname());
			pstmt.setInt(3, dto.getMno());
			res = pstmt.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return res;
	}
	
	public int delete(int mno) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MYTEST WHERE MNO=?";
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			res = pstmt.executeUpdate();
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return res;
	}
	
	public MyTestDto tSelect(int mno) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MYTEST WHERE MNO=?";
		MyTestDto dto = new MyTestDto();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setMno(rs.getInt(1));
				dto.setMname(rs.getString(2));
				dto.setNickname(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return dto;
	}
	
}









































