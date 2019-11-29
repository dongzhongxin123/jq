package com.baizhi.service;

import com.baizhi.dao.DeptDao;
import com.baizhi.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Dept> findAllDeptByPage(Integer page, Integer rows) {
        Integer start = (page - 1) * rows;
        List<Dept> allDeptByPage = deptDao.findAllDeptByPage(start, rows);
        return allDeptByPage;
    }

    @Override
    public Integer queryCountDept() {
        return deptDao.findCount();
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public void deleteDept(String id) {
        deptDao.deleteDept(id);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }
}
