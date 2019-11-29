package com.baizhi.service;

import com.baizhi.dao.EmpDap;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDap empDap;

    @Override
    public List<Emp> findAll() {
        List<Emp> emps = empDap.selectAllEmp();
        return emps;
    }

    @Override
    public List<Emp> selectEmpAndDept() {
        return empDap.selectEmpAndDept();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> selectEmpByPage(Integer page, Integer rows) {
        Integer start = (page - 1) * rows;
        System.out.println("start======" + start + "rows=======" + rows);
        List<Emp> allByPage = empDap.findAllByPage(start, rows);
        return allByPage;
    }

    @Override
    public Integer selectTotal() {
        return empDap.selectTotal();
    }

    @Override
    public void add(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDap.save(emp);
    }

    @Override
    public void delete(String id) {
        empDap.deleteEmpById(id);
    }

    @Override
    public void update(Emp emp) {
        empDap.update(emp);
    }
}
