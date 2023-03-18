package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Employee;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 20:25
 * @Description
 */
public interface EmployeeService {
    /*
    查询所有员工信息
     */
    List<Employee> getAllEmployee();

    /*
    获取员工分页信息
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
