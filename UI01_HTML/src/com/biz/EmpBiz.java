package com.biz;

import java.util.List;

import com.dto.EmpDto;

public interface EmpBiz {

	public List<EmpDto> selectList();
	public EmpDto selectOne(int empno);
	public int insert(EmpDto dto);
	public int update(EmpDto dto);
	public int delete(EmpDto dto);
	public EmpDto selectSalary(int empno);
	
}
