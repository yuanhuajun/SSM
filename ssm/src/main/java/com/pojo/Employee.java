package com.pojo;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/2/25 20:49
 * @Description
 */


public class Employee {
    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    private String email;

    public Employee() {
    }

    public Employee(Integer empId, String empName, Integer age, String gender,
                    String email) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

