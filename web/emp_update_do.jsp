<%@ page import="com.hanker.factory.DaoFactory" %>
<%@ page import="com.hanker.dao.EmployeeDao" %>
<%@ page import="com.hanker.entity.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 宝宝
  Date: 2020/3/30
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<%
    //获取数据
    request.setCharacterEncoding("utf8");
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String phoneNumber = request.getParameter("phoneNumber");
    //调用业务方法
    EmployeeDao emp = DaoFactory.getBean("emp");
    Employee employee = new Employee();
    employee.setFirstName(name);
    employee.setEmployeeId(id);
    employee.setLastName(lastName);
    employee.setEmail(email);
    employee.setPhoneNumber(phoneNumber);
    System.out.println(employee);
    int rows = emp.updateEmp(employee);
    //根据结果跳转
    if (rows> 0){
        out.println("<script>alert('更新成功');window.location.href='emp_list.jsp'</script>");
        /*System.out.println("删除成功!");
        response.sendRedirect("emp_list.jsp"); //跳转页面*/
    }else{
        out.println("更新失败!");
    }


    //获得id


    /*first_name =?, last_name =?, email=?, phone_number=?*/
%>

</body>
</html>
