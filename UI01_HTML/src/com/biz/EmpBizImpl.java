package com.biz;

import java.util.List;

import com.dao.EmpDao;
import com.dao.EmpDaoImpl;
import com.dto.EmpDto;

public class EmpBizImpl implements EmpBiz {

	EmpDao dao = new EmpDaoImpl();
	
	@Override
	public List<EmpDto> selectList() {
		return dao.selectList();
	}

	@Override
	public EmpDto selectOne(int empno) {
		return dao.selectOne(empno);
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

	@Override
	public EmpDto selectSalary(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

}
