package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.AnswerTxt;

public interface AnswerTxtDao {

	public int create(AnswerTxt answerTxt);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<AnswerTxt> query(Map<String, Object> paramMap);

	public AnswerTxt detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}