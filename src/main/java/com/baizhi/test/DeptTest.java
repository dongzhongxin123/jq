package com.baizhi.test;

import com.baizhi.SpringBootJG;
import com.baizhi.entity.Dept;
import com.baizhi.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringBootJG.class)
@RunWith(SpringRunner.class)
public class DeptTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void test1() {

        List<Dept> allDeptByPage = deptService.findAllDeptByPage(1, 1);
        System.out.println("allDeptByPage = " + allDeptByPage);

    }
}
