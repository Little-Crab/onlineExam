package com.crab.entity;

import com.crab.utils.Entity;

import java.util.Date;
import java.util.List;


/**
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class Exam extends Entity {
    public static final String state_noRun = "未开始";
    public static final String state_run = "考试中";
    public static final String state_end = "已结束";

    private Integer id;

    private String title;

    private String remark;

    private String state;
    private Date startTime;
    private Date endTime;
    private String url;
    private String examLength;
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getExamLength() {
        return examLength;
    }

    public void setExamLength(String examLength) {
        this.examLength = examLength;
    }
}