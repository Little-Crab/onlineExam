package com.crab.controller;

import com.crab.entity.Department;
import com.crab.service.DepartmentService;
import com.crab.utils.MapControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialStruct;
import java.util.List;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/13 21:41
 */
@Controller
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Department department) {
        List<Department> query = service.query(department);
        Integer count = service.count(department);
        return MapControl.getInstance().page(query, count).getMap();
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

    @GetMapping("/create")
    public String create() {
        return "dept/add";
    }

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Department department) {
        int flag = service.create(department);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }

    }

    @GetMapping("/list")
    public String list() {
        return "dept/list";
    }
}
