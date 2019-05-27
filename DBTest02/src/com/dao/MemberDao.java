package com.dao;

import java.util.List;

import com.dto.MemberDto;

public interface MemberDao {

	// Interface : 자동 상수화
	String selectListSql = "SELECT * FROM TB_MEMBER";
	static final String selectOneSql = "SELECT * FROM TB_MEMBER WHERE M_NO=?";
	String insertSql = "INSERT INTO TB_MEMBER "
						+ "VALUES(MEMBERSEQ.NEXTVAL,?,?,?,?,?,?,?)";
	String updateSql = "UPDATE TB_MEMBER SET M_NAME=?, M_AGE=?, M_GENDER=?, M_LOCATION=?,"
						+ "M_JOB=?, M_TEL=?, M_EMAIL=? WHERE M_NO=?";
	String deleteSql = "DELETE FROM TB_MEMBER WHERE M_NO=?";
	
	public List<MemberDto> selectList();
	public MemberDto selectOne(int m_no);
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(int m_no);
}
