package com.crab.entity;

import com.crab.utils.Entity;
import java.util.Date;


/**
 * 
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class Department extends Entity{

	private Integer deptId;

	private String deptName;

	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}