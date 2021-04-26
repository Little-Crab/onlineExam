package com.crab.service;


import com.crab.dao.DepartmentDao;
import com.crab.dao.MajorDao;
import com.crab.entity.Major;
import com.crab.utils.BeanMapUtils;
import com.crab.utils.MapParameter;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MajorService {

    @Autowired
    private MajorDao majorDao;
    @Autowired
    private DepartmentDao departmentDao;

    public int create(Major major) {
        return majorDao.create(major);
    }

    public int deleteBatch(String ids) {
       List<String> id= Splitter.on(",").splitToList(ids);
        int row = 0;
        for (String s : id) {
            if (!Strings.isNullOrEmpty(s)) {
                majorDao.delete(MapParameter.getInstance().add("majorId",Integer.parseInt(s)).getMap());
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return majorDao.delete(MapParameter.getInstance().add("majorId",id).getMap());
    }

    public int update(Major major) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(major)).getMap();
        return majorDao.update(map);
    }

    public List<Major> query(Major major) {
        PageHelper.startPage(major.getPage(), major.getLimit());
        return majorDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMap(major)).getMap());
    }

    public Major detail(Integer id) {
        Major major = majorDao.detail(MapParameter.getInstance().add("majorId",id).getMap());
        major.setDepartment(departmentDao.detail(MapParameter.getInstance().add("deptId", major.getDeptId()).getMap()));
        return major;
    }

    public int count(Major major) {
        return majorDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(major)).getMap());
    }
}
