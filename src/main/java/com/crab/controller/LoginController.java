package com.crab.controller;

import com.crab.entity.Admin;
import com.crab.service.AdminService;
import com.crab.service.ClassService;
import com.crab.service.DepartmentService;
import com.crab.service.MajorService;
import com.crab.utils.MD5Utils;
import com.crab.utils.MapControl;
import com.crab.utils.RandomCaptchaCode;
import com.crab.utils.SessionUtils;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/11 12:29
 */
@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClassService classService;
    @Autowired
    private DepartmentService deptService;
    @Autowired
    private MajorService majorService;

    @GetMapping("/login")
    public String login_v() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        System.out.println(map);
        //使用ajax返回的是json数据
        //从map中获取id，password，identitytype，captcha
        String id = map.get("id") + "";
        String password = map.get("password") + "";
        int identitytype = Integer.parseInt(map.get("identitytype") + "");
        String captcha = map.get("captcha") + "";
        //从Session中获取生成的验证码，并通过toLowerCase方法转换成小写
        String captchaCheck = request.getSession().getAttribute("randomcode_key").toString().toLowerCase(Locale.ROOT);

        //潘顿输入的账号密码是否为空，为空进行提示
        if (Strings.isNullOrEmpty(id) || Strings.isNullOrEmpty(password)) {
            return MapControl.getInstance().error("账号密码不能为空!!!").getMap();
        }
        //判断验证码是否正确，验证码正确进行
        if (captcha.toLowerCase(Locale.ROOT).equals(captchaCheck)) {
            //通过service的login方法进行判断是否查询到对象
            Admin admin = adminService.login(id, MD5Utils.getMd5(password), identitytype);

            //查询到的对象不为空
            if (admin != null) {
                admin.setClass_exam(classService.detail(admin.getClassId()));
                admin.setDepartment(deptService.detail(admin.getDeptId()));
                admin.setMajor(majorService.detail(admin.getMajorId()));
                //将对象添加到Session中
                SessionUtils.setAdmin(request, admin);
                //返回登录成功的信息
                return MapControl.getInstance().success("登录成功").getMap();
            } else {
                //返回登录失败的信息
                return MapControl.getInstance().error("用户名或密码错误").getMap();
            }
        } else {
            //返回验证码错误的信息
            return MapControl.getInstance().error("验证码错误").getMap();
        }
    }

    @RequestMapping(value = "/captcha")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        //创建生成验证的对象
        RandomCaptchaCode randomCaptchaCode = new RandomCaptchaCode();
        try {
            //获取输出图片
            randomCaptchaCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
