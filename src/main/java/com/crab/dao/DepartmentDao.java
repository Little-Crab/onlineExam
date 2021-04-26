package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.Department;

public interface DepartmentDao {

	public int create(Department department);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<Department> query(Map<String, Object> paramMap);

	public Department detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}