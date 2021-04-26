package com.crab.entity;

import com.crab.utils.Entity;

import java.util.Date;


/**
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class Course extends Entity {

    private Integer id;
    private Integer courseId;

    private String courseName;
    private Integer classId;

    private String teacherId;

    private Class_exam classExam;
    private Admin teacher;

    public Class_exam getClassExam() {
        return classExam;
    }

    public void setClassExam(Class_exam classExam) {
        this.classExam = classExam;
    }

    public Admin getTeacher() {
        return teacher;
    }

    public void setTeacher(Admin teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}