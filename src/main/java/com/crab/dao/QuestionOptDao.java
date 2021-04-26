package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.QuestionOpt;

public interface QuestionOptDao {

	public int create(QuestionOpt questionOpt);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<QuestionOpt> query(Map<String, Object> paramMap);

	public QuestionOpt detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}