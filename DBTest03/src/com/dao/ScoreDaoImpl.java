package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.dto.ScoreDto;
import common.JDBCTemplate;

public class ScoreDaoImpl extends JDBCTemplate implements ScoreDao {
	
	@Override
	public List<ScoreDto> AllSelect() {
		List<ScoreDto> list = new ArrayList<ScoreDto>();
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(ALL_SELECT_SQL);
			while(rs.next()) {
				ScoreDto dto = new ScoreDto();
				dto.setSname(rs.getString(1));
				dto.setSkor(rs.getInt(2));
				dto.setSeng(rs.getInt(3));
				dto.setSmath(rs.getInt(4));
				dto.setSsum(rs.getInt(5));
				dto.setSavg(rs.getDouble(6));
				dto.setSgrade(rs.getString(7));
				
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
	public ScoreDto TargetSelect(String TargetSname) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScoreDto dto = null;
		
		try {
			pstmt = con.prepareStatement(TARGET_SELECT_SQL);
			pstmt.setString(1, TargetSname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ScoreDto();
				dto.setSname(rs.getString(1));
				dto.setSkor(rs.getInt(2));
				dto.setSeng(rs.getInt(3));
				dto.setSmath(rs.getInt(4));
				dto.setSsum(rs.getInt(5));
				dto.setSavg(rs.getDouble(6));
				dto.setSgrade(rs.getString(7));
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

	@Override
	public int insert(ScoreDto dto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getSkor());
			pstmt.setInt(3, dto.getSeng());
			pstmt.setInt(4, dto.getSmath());
			pstmt.setInt(5, dto.getSsum());
			pstmt.setDouble(6, dto.getSavg());
			pstmt.setString(7, dto.getSgrade());
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
	public int update(ScoreDto dto) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(UPDATE_SQL);
			pstmt.setInt(1, dto.getSkor());
			pstmt.setInt(2, dto.getSeng());
			pstmt.setInt(3, dto.getSmath());
			pstmt.setInt(4, dto.getSsum());
			pstmt.setDouble(5, dto.getSavg());
			pstmt.setString(6, dto.getSgrade());
			pstmt.setString(7, dto.getSname());
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
	public int delete(String sname) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(DELETE_SQL);
			pstmt.setString(1, sname);
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
	public ScoreDto rankSelect(int rank) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScoreDto dto = new ScoreDto();
		
		try {
			pstmt = con.prepareStatement(RANK_SELECT_SQL);
			pstmt.setInt(1, rank);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setSname(rs.getString(1));
				dto.setSkor(rs.getInt(2));
				dto.setSeng(rs.getInt(3));
				dto.setSmath(rs.getInt(4));
				dto.setSsum(rs.getInt(5));
				dto.setSavg(rs.getDouble(6));
				dto.setSgrade(rs.getString(7));
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
