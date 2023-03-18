package com.mapper;

import com.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/11 17:37
 * @Description
 */
public interface DeptMapper {
    /**
     * 通过分步查询员工及对应部门信息的第二步
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查询部门及部门中员工信息
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询部门及其员工信息的第一步
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
