package com.biz;

import java.sql.Connection;
import java.util.List;

import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {

	ScoreDao dao = new ScoreDaoImpl();
	
	@Override
	public List<ScoreDto> AllSelect() {
		return dao.AllSelect();
	}

	@Override
	public ScoreDto TargetSelect(String TargetSname) {
		return dao.TargetSelect(TargetSname);
	}

	@Override
	public int insert(ScoreDto dto) {
		int skor = dto.getSkor();
		int seng = dto.getSeng();
		int smath = dto.getSmath();
		int ssum = skor + seng + smath;
		double savg = Math.round(((double)ssum/3)*100)/100.0;
		dto.setSsum(skor + seng + smath);
		dto.setSavg(savg);
		int grade = (int)savg/10;
		if(grade >= 9) {
			dto.setSgrade("A");
		} else if(grade >= 8) {
			dto.setSgrade("B");
		} else if(grade >= 7) {
			dto.setSgrade("C");
		} else if(grade >= 6) {
			dto.setSgrade("D");
		} else {
			dto.setSgrade("F");
		}
		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDto dto) {
		int skor = dto.getSkor();
		int seng = dto.getSeng();
		int smath = dto.getSmath();
		int ssum = skor + seng + smath;
		double savg = Math.round(((double)ssum/3)*100)/100.0;
		dto.setSsum(skor + seng + smath);
		dto.setSavg(savg);
		int grade = (int)savg/10;
		if(grade >= 9) {
			dto.setSgrade("A");
		} else if(grade >= 8) {
			dto.setSgrade("B");
		} else if(grade >= 7) {
			dto.setSgrade("C");
		} else if(grade >= 6) {
			dto.setSgrade("D");
		} else {
			dto.setSgrade("F");
		}
		return dao.update(dto);
	}

	@Override
	public int delete(String sname) {
		return dao.delete(sname);
	}

	@Override
	public ScoreDto rankSelect(int rank) {
		return dao.rankSelect(rank);
	}

}
