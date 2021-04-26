package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.Major;

public interface MajorDao {

	public int create(Major major);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<Major> query(Map<String, Object> paramMap);

	public Major detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}