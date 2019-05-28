package com.biz;

import java.util.List;

import com.dto.ScoreDto;

public interface ScoreBiz {

	public List<ScoreDto> AllSelect();
	public ScoreDto TargetSelect(String sname);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(String sname);
	public ScoreDto rankSelect(int rank);
	
}