package com.crab.entity;

import com.crab.utils.Entity;

import java.util.Date;
import java.util.List;


/**
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class Question extends Entity {

    private Integer id;

    private String title;

    private String remark;
    private Integer type;
    private Integer score;
    private Integer creator;
    private Date createTime;
    private Integer examId;
    private List<QuestionOpt> options;
    private QuestionResult result;
    private List<QuestionMore> more;

    public List<QuestionMore> getMore() {
        return more;
    }

    public void setMore(List<QuestionMore> more) {
        this.more = more;
    }

    public QuestionResult getResult() {
        return result;
    }

    public void setResult(QuestionResult result) {
        this.result = result;
    }

    public List<QuestionOpt> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOpt> options) {
        this.options = options;
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", remark='" + remark + '\'' +
                ", type=" + type +
                ", score=" + score +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", examId=" + examId +
                ", options=" + options +
                ", result=" + result +
                '}';
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }
}