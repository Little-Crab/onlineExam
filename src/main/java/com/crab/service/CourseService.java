package com.crab.service;


import com.crab.dao.CourseDao;
import com.crab.entity.Major;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.crab.entity.Course;

import com.crab.utils.BeanMapUtils;
import com.crab.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public int create(Course course) {
        return courseDao.create(course);
    }

    public int deleteBatch(String ids) {
        List<String> id = Splitter.on(",").splitToList(ids);
        System.out.println(ids);
        int row = 0;
        for (String s : id) {
            courseDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            row++;
        }
        return row;
    }

    public int delete(Integer id) {
        return courseDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int update(Course course) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(course)).addId(course.getId()).getMap();
        return courseDao.update(map);
    }

    public List<Course> query(Course course) {
        PageHelper.startPage(course.getPage(), course.getLimit());
        return courseDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMap(course)).getMap());
    }

    public Course detail(Integer id) {
        Course course = courseDao.detail(MapParameter.getInstance().addId(id).getMap());
        courseDao.detail(MapParameter.getInstance().addId(id).getMap());
        return course;
    }

    public int count(Course course) {
        return courseDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(course)).getMap());
    }
}
