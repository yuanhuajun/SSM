package com.mapper;

import com.pojo.Employee;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 20:36
 * @Description
 */
public interface EmployeeMapper {

    //查询所有员工信息
    List<Employee> getAllEmployee();
}
