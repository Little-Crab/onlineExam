package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.AnswerMore;

public interface AnswerMoreDao {

	public int create(AnswerMore answerMore);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<AnswerMore> query(Map<String, Object> paramMap);

	public AnswerMore detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}