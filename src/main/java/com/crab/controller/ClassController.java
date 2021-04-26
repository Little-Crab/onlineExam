package com.crab.controller;

import com.crab.entity.Class_exam;
import com.crab.service.ClassService;
import com.crab.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/13 21:43
 */
@Controller
@RequestMapping("class")
public class ClassController {
    @Autowired
    private ClassService service;

    @PostMapping("query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Class_exam class_exam) {
        List<Class_exam> query = service.query(class_exam);
        Integer count = service.count(class_exam);
        return MapControl.getInstance().page(query, count).getMap();
    }
}
