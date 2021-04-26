package com.crab.service;


import com.crab.dao.AdminDao;
import com.crab.entity.Admin;
import com.crab.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.crab.utils.BeanMapUtils;
import com.crab.utils.MapParameter;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public int create(Admin admin) {
        admin.setPassword(MD5Utils.getMd5(admin.getPassword()));
        return adminDao.create(admin);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!Strings.isNullOrEmpty(s)) {
                adminDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return adminDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int deleteBatch(String ids) {
        int flag = 0;
        List<String> id = Splitter.on(",").splitToList(ids);
        for (String s : id) {
            adminDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int update(Admin admin) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(admin)).addId(admin.getId()).getMap();
        return adminDao.update(map);
    }

    public List<Admin> query(Admin admin) {
        PageHelper.startPage(admin.getPage(), admin.getLimit());
        return adminDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMap(admin)).getMap());
    }

    public Admin detail(Integer id) {
        return adminDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Admin admin) {
        return adminDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(admin)).getMap());
    }

    public Admin login(String id, String password, Integer identitytype) {
        Map admin = MapParameter.getInstance().add("id", id).add("password", password).add("identitytype", identitytype).getMap();
        return adminDao.detail(admin);
    }
}
