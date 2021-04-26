package com.crab.service;


import com.crab.dao.QuestionDao;
import com.crab.dao.QuestionOptDao;
import com.crab.dao.QuestionResultDao;
import com.crab.entity.Question;
import com.crab.entity.QuestionOpt;
import com.crab.entity.QuestionResult;
import com.crab.utils.BeanMapUtils;
import com.crab.utils.MapParameter;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuestionOptDao questionOptDao;
    @Autowired
    private QuestionResultDao questionResultDao;

    public int create(Question question) {
        int flag;
        if (question.getId() != null) {
            System.out.println("这里应该执行");
            System.out.println(question);
            flag = this.update(question);
            questionOptDao.delete(MapParameter.getInstance().add("questionId", question.getId()).getMap());
            questionResultDao.delete(MapParameter.getInstance().add("questionId", question.getId()).getMap());
        } else {
            flag = questionDao.create(question);
        }
        if (flag > 0) {
            if (question.getType() == 1 || question.getType() == 2) {
                List<QuestionOpt> options = question.getOptions();
                for (QuestionOpt option : options) {
                    option.setExamId(question.getExamId());
                    option.setQuestionId(question.getId());
                    questionOptDao.create(option);
                }
            } else if (question.getType() == 3) {
                QuestionResult result = question.getResult();
                result.setQuestionId(question.getId());
                result.setExamId(question.getExamId());
                questionResultDao.create(result);
            }
        }
        return question.getId();
    }

    public int deleteBatch(String ids) {
        int flag = 0;
        List<String> strings = Splitter.on(",").splitToList(ids);
        for (String s : strings
        ) {
            questionDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            questionOptDao.delete(MapParameter.getInstance().add("questionId", Integer.parseInt(s)).getMap());
            questionResultDao.delete(MapParameter.getInstance().add("questionId", Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int delete(Integer id) {
        return questionDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int update(Question question) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).addId(question.getId()).getMap();
        return questionDao.update(map);
    }

    public List<Question> query(Question question) {
        //仅仅查询的问题
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).getMap();
        List<Question> questionList = questionDao.query(map);
        List<QuestionOpt> optList = questionOptDao.query(MapParameter.getInstance().add("examId", question.getExamId()).getMap());
        List<QuestionResult> resultList = questionResultDao.query(MapParameter.getInstance().add("examId", question.getExamId()).getMap());
        for (Question question1 : questionList) {
            if (question1.getType() == 1 || question1.getType() == 2) {
                List<QuestionOpt> options = new ArrayList<>();
                for (QuestionOpt questionOpt : optList) {
                    if (question1.getId().equals(questionOpt.getQuestionId())) {
                        options.add(questionOpt);
                    }
                }
                question1.setOptions(options);
            } else if (question1.getType() == 3) {
                for (QuestionResult questionResult : resultList) {
                    if (question1.getId().equals(questionResult.getQuestionId())) {
                        question1.setResult(questionResult);
                    }
                }

            }
        }
        return questionList;
    }

    public Question detail(Integer id) {
        Question question = questionDao.detail(MapParameter.getInstance().addId(id).getMap());
        questionDao.detail(MapParameter.getInstance().addId(id).getMap());
        return question;
    }

    public int count(Question question) {
        return questionDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).getMap());
    }
}
