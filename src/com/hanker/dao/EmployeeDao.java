package com.hanker.dao;

import com.hanker.entity.Employee;

import java.util.List;

//根据业务需求写方法 register 注册   login登录
public interface EmployeeDao {
    /**
     * 添加方法
     *
     * @param e 员工对象
     * @return受影响的行数
     */
    int saveEmp(Employee e);

    /**
     * 更新方法
     *
     * @param e 员工对象
     * @return受影响的行数
     */
    int updateEmp(Employee e);

    /**
     * 根据id删除数据
     *
     * @param id 员工id
     * @return受影响的行数
     */
    int deleteEmp(int id);
    int updateEmpStatus(int id);

    /**
     * 也可以分页查询
     *
     * @return
     */
    List<Employee> findAll();
}
