package com.crab.controller;

import com.crab.entity.Major;
import com.crab.service.DepartmentService;
import com.crab.service.MajorService;
import com.crab.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/13 15:54
 */
@Controller
@RequestMapping("major")
public class MajorController {
    @Autowired
    private MajorService service;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Major major) {
        List<Major> query = service.query(major);
        for (Major major1 : query) {
            major1.setDepartment(departmentService.detail(major1.getDeptId()));
        }
        Integer count = service.count(major);
        return MapControl.getInstance().page(query, count).getMap();
    }

    @GetMapping("/list")
    public String list() {
        return "major/list";
    }

    @GetMapping("create")
    public String create() {
        return "major/add";
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Major major) {
        System.out.println(major);
        int flag = service.create(major);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
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

}
