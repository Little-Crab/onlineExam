package com.crab.controller;

import com.crab.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Little_Crab
 * @date 2021/4/12 18:04
 */
@Controller
public class IndexController {
    @Value("classpath:init.json")
    private Resource resource;
    @Value("classpath:initTeacher.json")
    private Resource teacherResource;
    @Value("classpath:initStudent.json")
    private Resource studentResource;

    @GetMapping("/index")
    public String menu() {
        return "index";
    }

    @GetMapping("/menu")
    @ResponseBody
    public void menu(HttpServletResponse response, HttpServletRequest request) {
        Integer identitytype = SessionUtils.getAdmin(request).getIdentitytype();
        try {
            File file = null;
            if (identitytype == 0) {
                file = resource.getFile();
            } else if (identitytype == 1) {
                file = teacherResource.getFile();
            } else if (identitytype == 2) {
                file = studentResource.getFile();
            }
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String str;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            isr.close();
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
