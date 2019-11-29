package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ems")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("queryAll")
    @ResponseBody
    public List<Emp> queryAll() {

        List<Emp> all = empService.findAll();
        System.out.println(all);
        return all;
    }

    @RequestMapping("queryAllEmpAndDept")
    @ResponseBody
    public List<Emp> queryAllEmpAndDept() {
        List<Emp> emps = empService.selectEmpAndDept();
        return emps;
    }

    @RequestMapping("queryAllEmpByPage")
    @ResponseBody
    public Map<String, Object> queryAllEmpByPage(Integer page, Integer rows) {
        /**
         * total：总页数
         * page：当前页
         * records总条数
         * rows:集合
         *
         * 根据返回的json，可知得到的是一个对象，里面有以上四个值
         */
        Map<String, Object> map = new HashMap<>();
        List<Emp> emps = empService.selectEmpByPage(page, rows);
        Integer count = empService.selectTotal();
        long total = count % rows == 0 ? count / rows : count / rows + 1;
        map.put("total", total);
        map.put("rows", emps);
        map.put("page", page);
        map.put("records", count);
        return map;
    }

    @RequestMapping("edit")
    @ResponseBody
    public void edit(Emp emp, String oper) {
        //进行访问请求的判断
        if (oper.equals("add")) {
            empService.add(emp);
        } else if (oper.equals("edit")) {
            empService.update(emp);
        } else if (oper.equals("del")) {
            empService.delete(emp.getId());
        }

    }
}
