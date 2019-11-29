package com.baizhi.dao;

import com.baizhi.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {

    List<Dept> findAllDept();


    List<Dept> findAllDeptByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findCount();

    void addDept(Dept dept);

    void deleteDept(String id);

    void updateDept(Dept dept);

}
