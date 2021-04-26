package com.crab.entity;

import com.crab.utils.Entity;
import java.util.Date;


/**
 * 
 * @author 1339382950@qq.com
 * @time 2021-04-11 11:56:26
 */
public class QuestionOpt extends Entity{

	private Integer id;
	private Integer examId;
	private Integer questionId;
	private Integer type;

	private String opt;

	private String answer;

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
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}