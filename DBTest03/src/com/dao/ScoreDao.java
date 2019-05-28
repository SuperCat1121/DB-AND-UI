package com.dao;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreDao {

	String ALL_SELECT_SQL = "SELECT * FROM SCORE";
	String TARGET_SELECT_SQL = "SELECT * FROM SCORE WHERE SNAME=?";
	String INSERT_SQL = "INSERT INTO SCORE VALUES (?, ?, ?, ?, ?, ?, ?)";
	String UPDATE_SQL = "UPDATE SCORE SET SKOR = ?, SENG = ?, SMATH = ?, "
						+ "SSUM = ?, SAVG = ?, SGRADE = ? WHERE SNAME = ?";
	String DELETE_SQL = "DELETE FROM SCORE WHERE SNAME = ?";
	String RANK_SELECT_SQL = "SELECT * FROM SCORE WHERE SNAME = "
			+ "(SELECT SNAME FROM (SELECT SNAME, ROWNUM AS \"R\" FROM (SELECT * FROM SCORE ORDER BY SAVG DESC)) WHERE R=?)";

	
	public List<ScoreDto> AllSelect();
	public ScoreDto TargetSelect(String sname);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(String sname);
	public ScoreDto rankSelect(int rank);
}
