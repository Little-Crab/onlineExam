package com.crab.entity;

import com.crab.utils.Entity;
import org.checkerframework.checker.units.qual.Length;

import java.util.Date;


/**
 * 
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class Class_exam extends Entity{

	private Integer classId;
	private String className;

	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}