package com.crab.controller;

import com.crab.entity.Question;
import com.crab.entity.Exam;
import com.crab.service.QuestionService;
import com.crab.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Little_Crab
 * @date 2021/4/6 14:25
 */
@Controller
public class DynamicController {
    @Autowired
    private ExamService examService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/dy/{uuid}")
    public String preview(@PathVariable("uuid") String uuid, ModelMap modelMap) {
        Exam param = new Exam();
        param.setState(Exam.state_run);
        //查询问卷
        List<Exam> lists = examService.queryAll(param);
        Exam entity = null;
        for (Exam exam : lists
        ) {
            if (exam.getUrl().contains(uuid)) {
                entity = exam;
            }
        }
        if (entity == null) {
            modelMap.addAttribute("msg", "你要访问的页面已过期或不存在");
            return "error";
        } else {
            //定义一个对象，存储问卷id
            Question question = new Question();
            question.setExamId(entity.getId());
            //查询问题
            List<Question> questions = questionService.query(question);
            //将问题进行存储赋值
            entity.setQuestions(questions);
            modelMap.addAttribute("exam", entity);
            return "exam/exec";
        }
    }

    @GetMapping("/dy/success")
    public String success() {
        return "exam/success";
    }
}
