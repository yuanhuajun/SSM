package com.mapper;

import com.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/12 12:58
 * @Description
 */
public interface DynamicSQLMapper {

    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpyByCondition(Emp emp);

    /**
     * 使用choose查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpyByChoose(Emp emp);

    /**
     * 批量添加员工信息
     * @param emps
     */
    void insetMoreEmp(@Param("emps") List<Emp> emps);

    /**
     * 批量删除员工信息
     */
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
