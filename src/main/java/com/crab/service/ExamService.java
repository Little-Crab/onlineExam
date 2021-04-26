package com.crab.service;


import com.crab.dao.ExamDao;
import com.crab.entity.Exam;
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
public class ExamService {

    @Autowired
    private ExamDao examDao;

    public int create(Exam exam) {
        return examDao.create(exam);
    }

    public int delete(String ids) {

        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!Strings.isNullOrEmpty(s)) {
                examDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return examDao.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int deleteBatch(String ids) {
        int flag = 0;
        List<String> id = Splitter.on(",").splitToList(ids);
        for (String s : id) {
            examDao.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int update(Exam exam) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(exam)).addId(exam.getId()).getMap();
        return examDao.update(map);
    }

    public List<Exam> query(Exam exam) {
        PageHelper.startPage(exam.getPage(), exam.getLimit());
        return examDao.query(MapParameter.getInstance().put(BeanMapUtils.beanToMap(exam)).getMap());
    }

    public Exam detail(Integer id) {
        return examDao.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Exam exam) {
        return examDao.count(MapParameter.getInstance().put(BeanMapUtils.beanToMap(exam)).getMap());
    }

    public Exam login(String id, String password, Integer identitytype) {
        Map exam = MapParameter.getInstance().add("id", id).add("password", password).add("identitytype", identitytype).getMap();
        return examDao.detail(exam);
    }
    public List<Exam> queryAll(Exam exam) {
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(exam)).getMap();
        return examDao.query(map);
    }
    public void updateState() {
        List<Integer> list = examDao.queryByState(Exam.state_noRun);
        for (Integer id :
                list) {
            examDao.update(MapParameter.getInstance().add("state", Exam.state_run).addId(id).getMap());
        }
        List<Integer> list2 = examDao.queryByStateForExec(Exam.state_run);
        for (Integer id :
                list2) {
            examDao.update(MapParameter.getInstance().add("state", Exam.state_end).addId(id).getMap());
        }
    }
}
