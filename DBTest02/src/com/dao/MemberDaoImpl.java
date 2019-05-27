package com.dao;

import static common.JDBCTemplate.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<MemberDto> selectList() {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectListSql);
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		return list;
	}

	@Override
	public MemberDto selectOne(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto dto = new MemberDto();
		
		try {
			pstmt = con.prepareStatement(selectOneSql);
			pstmt.setInt(1, m_no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setM_no(rs.getInt(1));
				dto.setM_name(rs.getString(2));
				dto.setM_age(rs.getInt(3));
				dto.setM_gender(rs.getString(4));
				dto.setM_location(rs.getString(5));
				dto.setM_job(rs.getString(6));
				dto.setM_tel(rs.getString(7));
				dto.setM_email(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return dto;
	}

	@Override
	public int insert(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, dto.getM_name());
			pstmt.setInt(2, dto.getM_age());
			pstmt.setString(3, dto.getM_gender());
			pstmt.setString(4, dto.getM_location());
			pstmt.setString(5, dto.getM_job());
			pstmt.setString(6, dto.getM_tel());
			pstmt.setString(7, dto.getM_email());
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

	@Override
	public int update(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, dto.getM_name());
			pstmt.setInt(2, dto.getM_age());
			pstmt.setString(3, dto.getM_gender());
			pstmt.setString(4, dto.getM_location());
			pstmt.setString(5, dto.getM_job());
			pstmt.setString(6, dto.getM_tel());
			pstmt.setString(7, dto.getM_email());
			pstmt.setInt(8, dto.getM_no());
			res = pstmt.executeUpdate();
			if(res > 0) {
				System.out.println("수정 성공!");
				commit(con);
			} else {
				System.out.println("수정 실패..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int m_no) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, m_no);
			res = pstmt.executeUpdate();
			if(res > 0) {
				System.out.println("삭제 성공!");
				commit(con);
			} else {
				System.out.println("삭제 실패..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}

























