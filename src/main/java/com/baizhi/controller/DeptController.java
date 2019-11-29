package com.baizhi.controller;

import com.baizhi.entity.Dept;
import com.baizhi.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("findAllDept")
    @ResponseBody
    public void findAllDept(HttpServletResponse response) throws IOException {


        StringBuilder sb = new StringBuilder();
        sb.append("<select>");
        List<Dept> allDept = deptService.findAllDept();
        for (Dept dept : allDept) {
            System.out.println(dept);
            sb.append("<option value=\"").append(dept.getId()).append("\">").append(dept.getName()).append("</option>");
        }
        sb.append("</select>");

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(sb.toString());
    }

    @RequestMapping("queryAllDeptByPage")
    @ResponseBody
    public Map<String, Object> queryAllDeptByPage(Integer page, Integer rows) {
        /**
         * 分页满足四个条件
         *
         * total：总页数
         * page：当前页
         * records总条数
         * rows:集合
         */
        Map<String, Object> map = new HashMap<>();
        List<Dept> allDeptByPage = deptService.findAllDeptByPage(page, rows);
        Integer count = deptService.queryCountDept();
        long total = count % rows == 0 ? count / rows : count / rows + 1;
        map.put("rows", allDeptByPage);
        map.put("records", count);
        map.put("page", page);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public void edit(String oper, Dept dept) {
        if (oper.equals("add")) {
            deptService.addDept(dept);
        } else if (oper.equals("del")) {
            deptService.deleteDept(dept.getId());
        } else if (oper.equals("edit")) {
            deptService.updateDept(dept);
        }
    }
}
