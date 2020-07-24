<%@ page import="com.hanker.factory.DaoFactory" %>
<%@ page import="com.hanker.dao.EmployeeDao" %>
<%@ page import="com.hanker.entity.Employee" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新页面</title>
</head>
<body>
<%
    //获得id
    int id = Integer.parseInt(request.getParameter("id"));
    EmployeeDao emp = DaoFactory.getBean("emp");
    List<Employee> all = emp.findAll();
    Employee employee = all.get(0);
    /*first_name =?, last_name =?, email=?, phone_number=?*/
%>
<form action="emp_update_do.jsp<%--emp_update_do.jsp?id=<%=id%>--%>" method="post">
    <input type="hidden" name="id" value="<%=id%>">  <%--隐藏域 传参数 --%>
    <table>
        <tr>
            <td>姓氏:</td>
            <td><input type="text" name="firstName" value="<%= employee.getFirstName()%>"></td>
        </tr>
        <tr>
            <td>名字:</td>
            <td><input type="text"name="lastName" value="<%= employee.getLastName()%>"></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><input type="text" name="email" value="<%= employee.getEmail()%>"></td>
        </tr>
        <tr>
            <td>电话号码:</td>
            <td><input type="text"name="phoneNumber" value="<%= employee.getPhoneNumber()%>"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
