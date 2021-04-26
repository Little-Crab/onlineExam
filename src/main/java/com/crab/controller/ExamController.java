package com.crab.controller;

import com.crab.entity.Exam;
import com.crab.entity.Question;
import com.crab.service.DepartmentService;
import com.crab.service.ExamService;
import com.crab.service.QuestionService;
import com.crab.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Little_Crab
 * @date 2021/4/13 15:54
 */
@Controller
@RequestMapping("exam")
public class ExamController {
    @Autowired
    private ExamService service;
    @Autowired
    private QuestionService questionService;


    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Exam exam) {
        List<Exam> query = service.query(exam);
        Integer count = service.count(exam);
        return MapControl.getInstance().page(query, count).getMap();
    }

    @GetMapping("/list")
    public String list() {
        return "exam/list";
    }

    @GetMapping("create")
    public String create() {
        return "exam/add";
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Exam exam) {
        System.out.println(exam);
        exam.setState(Exam.state_noRun);
        int flag = service.create(exam);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }

    @GetMapping("/question")
    public String question(Integer id, ModelMap modelMap) {
        Exam exam = service.detail(id);
        modelMap.addAttribute("exam", exam);
        return "exam/question";
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        int flag = service.deleteBatch(ids);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }

    @PostMapping("/publish")
    @ResponseBody
    public Map<String, Object> publish(Integer id, HttpServletRequest request) {
        //从从数据库查询试卷的详细信息
        Exam param = service.detail(id);
        //判断是否在考试之中，如果不在考试时间内，返回错误信息不在时间内
        if (!Exam.state_run.equals(param.getState())) {
            return MapControl.getInstance().error("不在考试时间内").getMap();
        }
        //创建一个随机字符串使用/dy/开始，UUID进行拼接
        String uuid = "/dy/" + UUID.randomUUID().toString();
        //新建一个试卷
        Exam exam = new Exam();
        //设置试卷id
        exam.setId(id);
        //拼接链接
        String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + uuid;
        //将连接进行set
        exam.setUrl(url);
        //更新信息
        service.update(exam);
        //返回操作成功的信息
        return MapControl.getInstance().success().getMap();
    }

    @GetMapping("/preview/{id}")
    public String preview(@PathVariable("id") Integer id, ModelMap modelMap) {
        //查询问卷
        Exam exam = service.detail(id);
        //定义一个对象，存储问卷id
        Question question = new Question();
        question.setExamId(exam.getId());
        //查询问题
        List<Question> questions = questionService.query(question);
        //将问题进行存储赋值
        exam.setQuestions(questions);
        modelMap.addAttribute("exam", exam);
        return "exam/preview";
    }
}
