package com.dao;

import java.sql.*;
import java.util.*;

import com.common.JDBCTemplate;
import com.dto.EmpDto;

public class EmpDaoImpl extends JDBCTemplate implements EmpDao {

	@Override
	public List<EmpDto> selectList() {
		List<EmpDto> list = new ArrayList<EmpDto>();
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			while(rs.next()) {
				EmpDto dto = new EmpDto();
				dto.setEmpno(rs.getInt(1));
				dto.setEname(rs.getString(2));
				dto.setJob(rs.getString(3));
				dto.setMgr(rs.getInt(4));
				dto.setHiredate(rs.getString(5));
				dto.setSal(rs.getInt(6));
				dto.setComm(rs.getInt(7));
				dto.setDeptno(rs.getInt(8));
				dto.setSalary(rs.getInt(6)*12);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public EmpDto selectOne(int empno) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpDto dto = new EmpDto();
		
		try {
			pstmt = con.prepareStatement(SELECT_ONE_SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setEmpno(rs.getInt(1));
				dto.setEname(rs.getString(2));
				dto.setJob(rs.getString(3));
				dto.setMgr(rs.getInt(4));
				dto.setHiredate(rs.getString(5));
				dto.setSal(rs.getInt(6));
				dto.setComm(rs.getInt(7));
				dto.setDeptno(rs.getInt(8));
				dto.setSalary(rs.getInt(6)*12);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
