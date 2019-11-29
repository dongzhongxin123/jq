package com.baizhi.test;

import com.baizhi.SpringBootJG;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringBootJG.class)
@RunWith(SpringRunner.class)
public class EmpTest {

    @Autowired
    private EmpService empService;

    @Test
    public void test1() {

        List<Emp> all = empService.findAll();
        System.out.println("all = " + all);
    }

    @Test
    public void test2() {

        List<Emp> emps = empService.selectEmpAndDept();
        System.out.println("emps = " + emps);
    }
}
