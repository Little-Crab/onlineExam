package com.crab.entity;

import com.crab.utils.Entity;
import java.util.Date;


/**
 * 
 * @author 1339382950@qq.com
 * @time 2021-04-18 18:24:58
 */
public class QuestionResult extends Entity{

	private Integer id;
	private Integer examId;
	private Integer questionId;
	private Integer type;

	private String result;

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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}