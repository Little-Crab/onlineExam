package com.crab.test;


import com.crab.entity.*;
import com.crab.service.AdminService;
import com.crab.service.DepartmentService;
import com.crab.service.MajorService;
import com.crab.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminDaoTest {

    @Autowired
    private AdminService adminService;
    @Autowired
    private MajorService majorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private QuestionService questionService;

    @Test
    public void queryForOne() {
//        List<Admin> query = adminService.query(new Admin());
//        for (Admin admin : query) {
//            System.out.println(service.detail(2001));
//        }
        Admin admin = new Admin();
        String sno = "2018001";
        String name = "lisi";
        String password = "123456";
        String idcard = "411322199903111311";
        String phone = "15236067080";
        Integer classId = 3001;
        Integer deptId = 1001;
        Integer majorId = 2001;
        List<Integer> sex = new ArrayList<>();
        sex.add(0);
        sex.add(1);
        Integer nianji = 2019;
        List<Integer> grade = new ArrayList<>();
        grade.add(2018);
        grade.add(2019);
        grade.add(2017);
        grade.add(2020);
        String email = "1339382950@qq.com";

        for (int i = 0; i <= 150; i++) {
            int i1 = Integer.parseInt(sno) + i;
            admin.setId(String.valueOf(i1));
            admin.setPassword(password);
            admin.setName(name + i);
            admin.setIdcard(idcard);
            admin.setPhone(phone);
            admin.setClassId(classId);
            admin.setMajorId(majorId);
            admin.setDeptId(deptId);
            admin.setGrade(grade.get(new Random().nextInt(3)));
            admin.setEmail(email);
            admin.setSex(sex.get(new Random().nextInt(2)));
            admin.setIdentitytype(2);
            adminService.create(admin);
        }
    }

    @Test
    public void majorQueryTest() {
        List<Major> query = majorService.query(new Major());
        System.out.println(query);
    }

    @Test
    public void deleteAdminTest() {
        int delete = adminService.delete(2018062);
        System.out.println(delete);
    }

    @Test
    public void updateAdminTest() {
        Admin admin = new Admin();
        admin.setId("2018007");
        admin.setName("旁天真");
        admin.setPassword("123456");
        admin.setIdcard("411322199903111311");
        int update = adminService.update(admin);
        System.out.println(update);
    }

    @Test
    public void deleteBatchDeptTest() {
        int i = departmentService.deleteBatch("1002,1003");
        System.out.println(i);
    }

    @Test
    public void deleteBatchMajorTest() {
        int i = majorService.deleteBatch("2002");
        System.out.println(i);
    }

    @Test
    public void queryAdminTest() {
        Admin admin = new Admin();
        List<Admin> query = adminService.query(admin);
        System.out.println(query);
    }

    @Test
    public void questionCreate() {

    /*    List<QuestionOpt> opts = new ArrayList<>();

        Question question = new Question();
        question.setCreator(2018008);
        question.setExamId(1);
        question.setTitle("测试一下");
        question.setRemark("这是一个测试");
        question.setType(1);
        question.setScore(10);
        question.setOptions(opts);


        QuestionOpt opt = new QuestionOpt();
        opt.setOpt("测试啊啊啊啊啊0");
        opt.setType(1);
        QuestionOpt opt1 = new QuestionOpt();
        opt1.setOpt("测试啊啊啊啊啊1");
        opt1.setType(1);

        QuestionOpt opt2 = new QuestionOpt();
        opt2.setOpt("测试啊啊啊啊啊2");
        opt2.setType(1);

        QuestionOpt opt3 = new QuestionOpt();
        opt3.setOpt("测试啊啊啊啊啊3");
        opt3.setType(1);


        opts.add(opt);
        opts.add(opt1);
        opts.add(opt2);
        opts.add(opt3);
        int i = questionService.create(question);


        System.out.println(i);*/

        Question question = new Question();
        question.setScore(10);
        question.setTitle("这时简答题测试");
        question.setRemark("shiyishi");
        question.setCreator(2018008);
        question.setExamId(1);
        question.setType(3);
        QuestionResult result = new QuestionResult();
        result.setType(question.getType());
        result.setResult("这里是答案的天下");
        question.setResult(result);
        System.out.println(question);
        int i = questionService.create(question);
        System.out.println("xxxxxxxx");
        System.out.println("xxxxxxxx");
        System.out.println("xxxxxxxx");
    }
}