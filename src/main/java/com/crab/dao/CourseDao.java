package com.crab.dao;

import java.util.List;
import java.util.Map;

import com.crab.entity.Course;

public interface CourseDao {

	public int create(Course course);

	public int delete(Map<String, Object> paramMap);

	public int update(Map<String, Object> paramMap);

	public List<Course> query(Map<String, Object> paramMap);

	public Course detail(Map<String, Object> paramMap);

	public int count(Map<String, Object> paramMap);


}