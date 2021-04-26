package com.crab.entity;

import com.crab.utils.Entity;

import java.io.File;
import java.util.Date;


/**
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class Admin extends Entity {


    private String id;

    private String password;
    private Integer grade;
    private Integer majorId;

    private String name;
    private Integer sex;
    private Integer age;
    private Date birthday;
    private String idcard;
    private String phone;
    private String email;
    private Integer classId;
    private Integer deptId;
    private String headImg;
    private Integer identitytype;
    private Department department;
    private Class_exam class_exam;
    private Major major;
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Class_exam getClass_exam() {
        return class_exam;
    }

    public void setClass_exam(Class_exam class_exam) {
        this.class_exam = class_exam;
    }

    public String getId() {
        return id;
    }

    public void setId(String sno) {
        this.id = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getIdentitytype() {
        return identitytype;
    }

    public void setIdentitytype(Integer identitytype) {
        this.identitytype = identitytype;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                ", major=" + major +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday=" + birthday +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", classId=" + classId +
                ", deptId=" + deptId +
                ", headImg='" + headImg + '\'' +
                ", identitytype=" + identitytype +
                '}';
    }
}