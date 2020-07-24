package com.hanker.test;

import com.hanker.dao.EmployeeDao;
import com.hanker.dao.impl.EmployeeDaoImpl;
import com.hanker.entity.Employee;
import com.hanker.factory.DaoFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParseException {
        test();
    }

    private static void test3() {
        EmployeeDao emp = DaoFactory.getBean("emp");
        List<Employee> list = emp.findAll();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    private static void test2() {
        EmployeeDao empDao = new EmployeeDaoImpl();
        Employee emp = new Employee();
        emp.setEmployeeId(209);
        emp.setFirstName("小黑");
        emp.setLastName("小白");
        emp.setEmail ("heibai@163. com");
        emp.setPhoneNumber("13803711122");
        int rows = empDao.updateEmp(emp);
        System.out.println(rows);
    }

    private static void test() throws ParseException {
        EmployeeDao empDao = new EmployeeDaoImpl();
        Employee emp = new Employee();
        emp.setEmployeeId(3008);
        emp.setFirstName("小黑2");
        emp.setLastName("小白");
        emp.setEmail("dilireba@163. com");
        emp.setPhoneNumber("13838387438*");
        emp.setJobId("SH_ _CLERK");
        emp.setSalary(8899.77);
        emp.setCommissionPct(0.66);
        emp.setManagerId(1000);
        emp.setDepartmentId(100);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2020-1-1");


        long time = parse.getTime();
        System.out.println(time);
        emp.setHireDate(new java.sql.Date(time));

        int rows = empDao.saveEmp(emp);
        if (rows > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}

