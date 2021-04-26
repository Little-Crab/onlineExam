package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.Class_exam;

public interface Class_examDao {

	public int create(Class_exam class_exam);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<Class_exam> query(Map<String, Object> paramMap);

	public Class_exam detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}