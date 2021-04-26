package com.crab.entity;

import com.crab.utils.Entity;
import java.util.Date;


/**
 * 
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class AnswerTxt extends Entity{

	private Integer id;
	private Integer examId;
	private Integer questionId;

	private String result;
	private Date answerTime;
	private Integer examinee;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public Integer getExaminee() {
		return examinee;
	}
	public void setExaminee(Integer examinee) {
		this.examinee = examinee;
	}
}