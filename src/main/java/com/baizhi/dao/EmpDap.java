package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDap {

    List<Emp> selectAllEmp();

    List<Emp> selectEmpAndDept();

    List<Emp> findAllByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer selectTotal();

    void save(Emp emp);

    void deleteEmpById(String id);

    void update(Emp emp);
}
