package com.crab.controller;

import com.crab.entity.Admin;
import com.crab.entity.Class_exam;
import com.crab.entity.Major;
import com.crab.service.AdminService;
import com.crab.service.ClassService;
import com.crab.service.DepartmentService;
import com.crab.service.MajorService;
import com.crab.utils.MD5Utils;
import com.crab.utils.MapControl;
import com.crab.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ClassService classService;
    @Autowired
    private MajorService majorService;

    @GetMapping("create")
    public String create() {
        return "admin/add";
    }

    @PostMapping("create")
    @ResponseBody
    public Map<String, Object> create(@RequestBody Admin admin) {
        int flag = adminService.create(admin);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }

    public Map<String, Object> createBatch() {
        return null;
    }

    @PostMapping("delete")
    @ResponseBody
    public Map<String, Object> delete(String ids) {
        int flag = adminService.deleteBatch(ids);
        if (flag > 0) {
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }

    @PostMapping("update")
    @ResponseBody
    public Map<String, Object> update(@RequestBody Admin admin, HttpServletRequest request) {
        System.out.println(admin);
        int flag = adminService.update(admin);
        if (flag > 0) {
            SessionUtils.getAdmin(request).setHeadImg(admin.getHeadImg());
            return MapControl.getInstance().success().getMap();
        } else {
            return MapControl.getInstance().error().getMap();
        }
    }

/*
    @GetMapping("detail")
    public  String detail(Integer id){
        return  Result.ok(studentService.detail(id));
    }
*/

    @PostMapping("query")
    @ResponseBody
    public Map<String, Object> query(@RequestBody Admin admin) {
        List<Admin> list = adminService.query(admin);
        for (Admin admin1 : list) {
            Major majorDetail = majorService.detail(admin1.getMajorId());
            admin1.setClass_exam(classService.detail(admin1.getClassId()));
            admin1.setDepartment(majorDetail.getDepartment());
            admin1.setMajor(majorDetail);
        }
        Integer count = adminService.count(admin);
        return MapControl.getInstance().page(list, count).getMap();
    }

    @GetMapping("list")
    public String list() {
        return "admin/list";
    }

    @GetMapping("userSetting")
    public String userSetting() {
        return "admin/userSetting";
    }

    @PostMapping("/editPassword")
    @ResponseBody
    public Map<String, Object> editPassword(@RequestBody Map<String, String> map,
                                            HttpServletRequest request) {
        String new_password = map.get("new_password");
        String old_password = map.get("old_password");
        String again_password = map.get("again_password");
        if (!MD5Utils.getMd5(old_password).equals(SessionUtils.getAdmin(request).getPassword())) {
            return MapControl.getInstance().error("旧密码错误").getMap();
        } else {
            Admin admin = adminService.detail(Integer.parseInt(SessionUtils.getAdmin(request).getId()));
            admin.setPassword(MD5Utils.getMd5(new_password));
            adminService.update(admin);
            return MapControl.getInstance().success("密码更改成功").getMap();
        }
    }

    @GetMapping("editPassword")
    public String editPassword() {
        return "admin/editPassword";
    }

    //资源上传
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadResource(HttpServletRequest request, MultipartFile file) {
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/static/headimage/");
//        String path = "D:\\SSM\\headimg";
        System.out.println(path);
        //这里设置每个用户头像img只有一个
        String fileName = UUID.randomUUID() + "tou.jpg";
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        try {
            file.transferTo(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dir.getPath());
        //upload要求返回的数据格式
        Map<String, Object> uploadData = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        uploadData.put("code", "0");
        uploadData.put("msg", "ok");
        //将文件路径返回
        data.put("src", dir.getPath());
        data.put("filename", fileName);
        uploadData.put("data", data);
        return uploadData;
    }

}
