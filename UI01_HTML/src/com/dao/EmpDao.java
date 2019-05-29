package com.dao;

import java.util.List;

import com.dto.EmpDto;

public interface EmpDao {
	
	String SELECT_LIST_SQL = "SELECT * FROM EMPTEST";
	String SELECT_ONE_SQL = "SELECT * FROM EMPTEST WHERE EMPNO=?";
	String INSERT_SQL = "INSERT INTO EMPTEST VALUES (?,?,?,?,?,?,?,?)";
	String UPDATE_SQL = "UPDATE EMPTEST SET ENAME=?, JOB=?, MGR=?, HIREDATE=?,"
			+ " SAL=?, COMM=?, DEPTNO=? WHERE EMPNO=?";
	String DELETE_SQL = "DELETE FROM EMPTEST WHERE EMPNO=?";
	
	public List<EmpDto> selectList();
	public EmpDto selectOne(int empno);
	public int insert(EmpDto dto);
	public int update(EmpDto dto);
	public int delete(EmpDto dto);
	
}
