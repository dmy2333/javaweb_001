<%@ page import="com.hanker.factory.DaoFactory" %>
<%@ page import="com.hanker.dao.EmployeeDao" %><%--
  Created by IntelliJ IDEA.
  User: 宝宝
  Date: 2020/3/30
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除界面</title>
    <script>
    </script>
</head>
<body>
<%
    //获取id
    int id = Integer.parseInt(request.getParameter("id"));
    //2. 创建Dao对象
    EmployeeDao emp = DaoFactory.getBean("emp");
    //3.执行方法
    int rows = emp.updateEmpStatus(id);
    if (rows> 0){
        out.println("<script>alert('删除成功');window.location.href='emp_list.jsp'</script>");
        /*System.out.println("删除成功!");
        response.sendRedirect("emp_list.jsp"); //跳转页面*/
    }else{
        out.println("删除失败!");
    }
%>
</body>
</html>
