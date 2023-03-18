package com.mapper;

import com.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/12 15:11
 * @Description
 */
public interface CacheMapper {
    /**
     * 根据员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 添加员工信息
     */
    void insertEmp(Emp emp);
}
