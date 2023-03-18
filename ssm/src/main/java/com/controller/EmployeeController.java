package com.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pojo.Employee;
import com.service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 20:12
 * @Description
 */

/*
查询所有员工信息-->/employee-->get
查询员工分页信息-->/employee/page/1-->get
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "employee",method = RequestMethod.GET)
    public String getAllEmployee( Model model){
        //查询所有员工信息
      List<Employee> list = employeeService.getAllEmployee();
      //将员工信息在请求域中共享
        model.addAttribute("list",list);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/page/{pageNum}" ,method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model){
        //获取员工信息
        PageInfo<Employee> pageInfo = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page",pageInfo);
        return "employee_list";
    }
}
