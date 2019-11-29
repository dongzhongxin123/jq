package com.baizhi.service;

import com.baizhi.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAllDept();

    List<Dept> findAllDeptByPage(Integer page, Integer rows);

    Integer queryCountDept();

    void addDept(Dept dept);

    void deleteDept(String id);

    void updateDept(Dept dept);
}
