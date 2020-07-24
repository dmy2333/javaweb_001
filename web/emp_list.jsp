<%@ page import="com.hanker.factory.DaoFactory" %>
<%@ page import="com.hanker.dao.EmployeeDao" %>
<%@ page import="com.hanker.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <style>
        table, tr, td {
            border: 1px solid black;
            border-collapse: collapse; /*合并单元格边框*/
        }
    </style>
</head>
<body>
<%
    EmployeeDao emp = DaoFactory.getBean("emp");
    List<Employee> list = emp.findAll();
%>
<h1 align="center">员工列表</h1>
<a href="list_add.jsp">添加员工</a>
<table>
    <tr>
        <td>员工编号</td>
        <td>员工姓氏</td>
        <td>员工名字</td>
        <td>员工邮箱</td>
        <td>电话号码</td>
        <td>工作编号</td>
        <td>员工薪水</td>
        <td>员工奖金</td>
        <td>经理编号</td>
        <td>部门编号</td>
        <td>雇佣日期</td>
        <td>操作按钮</td>
    </tr>

    <%
        Employee employee = null;
        for (int i = 0; i < list.size(); i++) {
            employee = list.get(i);
    %>
    <tr>
        <td><%=employee.getEmployeeId()%>
        </td>
        <td><%=employee.getFirstName()%>
        </td>
        <td><%=employee.getLastName()%>
        </td>
        <td><%=employee.getEmail()%>
        </td>
        <td><%=employee.getPhoneNumber()%>
        </td>
        <td><%=employee.getJobId()%>
        </td>
        <td><%=employee.getSalary()%>
        </td>
        <td><%=employee.getCommissionPct()%>
        </td>
        <td><%=employee.getManagerId()%>
        </td>
        <td><%=employee.getDepartmentId()%>
        </td>
        <td><%=employee.getHireDate()%>
        </td>
        <td>
            <a href="emp_delete.jsp?id=<%=employee.getEmployeeId()%>">删除</a>
            <a href="emp_update.jsp?id=<%=employee.getEmployeeId()%>">修改</a>
            <a href="">订单</a>
        </td>
    </tr>
    <% }%>
</table>
</body>
</html>
