<%@ page import="com.hanker.factory.DaoFactory" %>
<%@ page import="com.hanker.dao.EmployeeDao" %>
<%@ page import="com.hanker.entity.Employee" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 宝宝
  Date: 2020/3/31
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>

</head>
<body>
<%
    //设置编码
    request.setCharacterEncoding("utf8");
    //获得数据
    int id = Integer.parseInt(request.getParameter("employeeId"));
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String email = request.getParameter("email");
    String phoneNumber = request.getParameter("phoneNumber");
    String jobId = request.getParameter("jobId");
    double salary = Double.parseDouble(request.getParameter("salary"));
    double commissionPct = Double.parseDouble(request.getParameter("commissionPct"));
    int managerId = Integer.parseInt(request.getParameter("managerId"));
    int departmentId = Integer.parseInt(request.getParameter("departmentId"));
    String hireDate = request.getParameter("hireDate");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
        System.out.println(hireDate);
        date = sdf.parse(hireDate);
        System.out.println(date);
    } catch (Exception e) {
        System.out.println("出现异常");
        e.printStackTrace();
    }
    long time = date.getTime();
    //业务操作
    EmployeeDao emp = DaoFactory.getBean("emp");
    Employee employee = new Employee();
    employee.setEmployeeId(id);
    employee.setFirstName(firstname);
    employee.setLastName(lastname);
    employee.setEmail(email);
    employee.setPhoneNumber(phoneNumber);
    employee.setJobId(jobId);
    employee.setSalary(salary);
    employee.setCommissionPct(commissionPct);
    employee.setManagerId(managerId);
    employee.setDepartmentId(departmentId);
    employee.setHireDate(new java.sql.Date(time));
    int rows = emp.saveEmp(employee);
    //判断,跳转
    if (rows > 0) {
        out.println("<script>alert('添加成功!');window.location.href='emp_list.jsp'</script>");
    } else {
        out.println("<script>alert('添加成功!')");
    }
%>
<form action="emp"></form>
</body>
</html>
