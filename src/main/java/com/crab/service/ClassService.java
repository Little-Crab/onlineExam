package com.crab.service;


import com.github.pagehelper.PageHelper;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.crab.entity.Class_exam;
import com.crab.dao.Class_examDao;
import com.crab.utils.BeanMapUtils;
import com.crab.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassService {

    @Autowired
    private Class_examDao classDao;

    public int create(Class_exam cla) {
        return classDao.create(cla);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!Strings.isNullOrEmpty(s)) {
                classDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return classDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int update(Class_exam cla) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(cla)).addId(cla.getClassId()).getMap();
        return classDao.update(map);
    }

    public List<Class_exam> query(Class_exam cla) {
        if (cla != null && cla.getPage() != null) {
            PageHelper.startPage(cla.getPage(), cla.getLimit());
        }
        return classDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMap(cla)).getMap());
    }

    public Class_exam detail(Integer id) {
        return classDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Class_exam cla) {
        return classDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(cla)).getMap());
    }
}
