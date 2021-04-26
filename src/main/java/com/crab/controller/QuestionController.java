package com.crab.controller;

import com.crab.entity.Exam;
import com.crab.entity.Question;
import com.crab.service.AdminService;
import com.crab.service.ClassService;
import com.crab.service.ExamService;
import com.crab.service.QuestionService;
import com.crab.utils.MapControl;
import com.crab.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/16 16:03
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ExamService examService;

    @GetMapping("list")
    public String list() {
        return "question/list";
    }

    @PostMapping("query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Question question, HttpServletRequest request) {
        List<Question> query = questionService.query(question);
        Integer count = questionService.count(question);
        return MapControl.getInstance().page(query, count).getMap();
    }

    @GetMapping("create")
    public String create() {
        return "question/add";
    }

    @PostMapping("create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Question question,HttpServletRequest request) {
        question.setCreator(Integer.parseInt(SessionUtils.getAdmin(request).getId()));

        int flag = questionService.create(question);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }



    @PostMapping("delete")
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        int flag = questionService.deleteBatch(ids);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }
}
