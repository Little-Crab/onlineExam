package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.Exam;

public interface ExamDao {

	public int create(Exam exam);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<Exam> query(Map<String, Object> paramMap);

	public Exam detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);
	public List<Integer> queryByState(String state);
	public List<Integer> queryByStateForExec(String state);


}