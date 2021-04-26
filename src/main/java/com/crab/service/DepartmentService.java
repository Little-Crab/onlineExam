package com.crab.service;


import com.crab.dao.DepartmentDao;
import com.crab.entity.Department;
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
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public int create(Department department) {
        return departmentDao.create(department);
    }

    public int deleteBatch(String ids) {
        List<String> id = Splitter.on(",").splitToList(ids);
        System.out.println(ids);
        int row = 0;
        for (String s : id) {
                departmentDao.delete(MapParameter.getInstance().add("deptId", Integer.parseInt(s)).getMap());
                row++;
        }
        return row;
    }

    public int delete(Integer id) {
        return departmentDao.delete(MapParameter.getInstance().add("deptId", id).getMap());
    }

    public int update(Department department) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(department)).addId(department.getDeptId()).getMap();
        return departmentDao.update(map);
    }

    public List<Department> query(Department department) {
        PageHelper.startPage(department.getPage(), department.getLimit());
        return departmentDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMap(department)).getMap());
    }

    public Department detail(Integer id) {
        return departmentDao.detail(MapParameter.getInstance().add("deptId", id).getMap());
    }

    public int count(Department department) {
        return departmentDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(department)).getMap());
    }
}
