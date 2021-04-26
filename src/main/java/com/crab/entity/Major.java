package com.crab.entity;

import com.crab.utils.Entity;

import java.util.Date;


/**
 * @author 1339382950@qq.com
 * @time 2021-04-13 09:04:12
 */
public class Major extends Entity {

    private Integer majorId;
    private String majorName;
    private Integer deptId;
    private Department department;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}