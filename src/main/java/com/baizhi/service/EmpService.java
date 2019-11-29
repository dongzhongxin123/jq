package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> findAll();

    List<Emp> selectEmpAndDept();

    List<Emp> selectEmpByPage(Integer page, Integer rows);

    Integer selectTotal();

    void add(Emp emp);

    void delete(String id);

    void update(Emp emp);
}
