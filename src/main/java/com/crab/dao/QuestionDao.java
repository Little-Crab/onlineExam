package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.Question;

public interface QuestionDao {

	public int create(Question question);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<Question> query(Map<String, Object> paramMap);

	public Question detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}