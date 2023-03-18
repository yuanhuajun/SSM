package com.mapper;

import com.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/11 11:08
 * @Description
 */


public interface EmpMapper {
    /**
     * 根据id
     * @param empId
     * @return
     */
    Emp getEmpByEmpid(@Param("empId") Integer empId);

    /**
     * 获取员工和部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 通过分步查询员工以及对应部门信息的第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);



    /**
     * 通过分步查询部门及其员工信息的第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
