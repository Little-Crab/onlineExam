package com.crab.controller;

import com.crab.entity.Course;
import com.crab.service.AdminService;
import com.crab.service.ClassService;
import com.crab.service.CourseService;
import com.crab.utils.MapControl;
import com.crab.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/16 16:03
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClassService classService;

    @GetMapping("list")
    public String list() {
        return "course/list";
    }

    @PostMapping("query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Course course, HttpServletRequest request) {
        course.setTeacherId(SessionUtils.getAdmin(request).getId());
        List<Course> query = courseService.query(course);
        for (Course course1 : query) {
            course1.setClassExam(classService.detail(course1.getClassId()));
            course1.setTeacher(adminService.detail(Integer.parseInt(course1.getTeacherId())));
        }
        Integer count = courseService.count(course);
        return MapControl.getInstance().page(query, count).getMap();
    }

    @GetMapping("create")
    public String create() {
        return "course/add";
    }

    @PostMapping("create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Course course) {
        int flag = courseService.create(course);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }
    @PostMapping("delete")
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        int flag = courseService.deleteBatch(ids);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }
}
