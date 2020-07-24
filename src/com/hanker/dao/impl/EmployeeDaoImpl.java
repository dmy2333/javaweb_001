package com.hanker.dao.impl;

import com.hanker.dao.EmployeeDao;
import com.hanker.entity.Employee;
import com.hanker.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public int updateEmpStatus(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update employees set status = ? where employee_id =? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, id);
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(ps,conn);
        }
        return rows;
    }

    @Override
    public int saveEmp(Employee e) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into employees(employee_id, first_name, last_name , email, phone_number,job_id, salary, commission_pct,manager_id,department_id,hiredate)" +
                    " values(?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, e.getEmployeeId());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getPhoneNumber());
            ps.setString(6, e.getJobId());
            ps.setDouble(7, e.getSalary());
            ps.setDouble(8, e.getCommissionPct());
            ps.setInt(9, e.getManagerId());
            ps.setInt(10, e.getDepartmentId());
            ps.setDate(11, e.getHireDate());
            rows = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(ps, conn);
        }
        return rows;
    }

    @Override
    public int updateEmp(Employee e) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update employees set first_name =?, last_name =?, email=?, phone_number=? where employee_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getFirstName());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPhoneNumber());
            ps.setInt(5, e.getEmployeeId());
            rows = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(ps, conn);
        }
        return rows;
    }

    @Override
    public int deleteEmp(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from employees where employee_id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rows = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(ps, conn);
        }
        return rows;
    }


    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT employee_id, first_name, last_name , email, phone_number,job_id, salary, commission_pct,manager_id,department_id,hiredate FROM employees where status = 0;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeId(rs.getInt(1));
                e.setFirstName(rs.getString("first_name"));
                e.setLastName(rs.getString(3));
                e.setEmail(rs.getString("email"));
                e.setPhoneNumber(rs.getString(5));
                e.setJobId(rs.getString("job_id"));
                e.setSalary(rs.getDouble("salary"));
                e.setCommissionPct(rs.getDouble(8));
                e.setManagerId(rs.getInt("manager_id"));
                e.setDepartmentId(rs.getInt(10));
                e.setHireDate(rs.getDate("hiredate"));
                //添加到容器
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return list;
    }
}
