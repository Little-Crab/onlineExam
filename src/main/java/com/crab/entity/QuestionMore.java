package com.crab.entity;

import com.crab.utils.Entity;

import java.util.Date;


/**
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class QuestionMore extends Entity {

    private Integer id;

    private String title;
    private Integer examId;
    private Integer questionId;
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}