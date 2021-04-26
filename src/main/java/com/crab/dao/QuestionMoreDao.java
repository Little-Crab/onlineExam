package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.QuestionMore;

public interface QuestionMoreDao {

	public int create(QuestionMore questionMore);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<QuestionMore> query(Map<String, Object> paramMap);

	public QuestionMore detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}