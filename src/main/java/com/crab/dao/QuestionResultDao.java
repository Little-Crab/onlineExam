package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.QuestionResult;

public interface QuestionResultDao {

	int create(QuestionResult questionResult);

	int delete(Map<String, Object> paramMap);

	int update(Map<String, Object> paramMap);

	List<QuestionResult> query(Map<String, Object> paramMap);

	QuestionResult detail(Map<String, Object> paramMap);

	int count(Map<String, Object> paramMap);


}