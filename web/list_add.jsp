<%@ page import="com.hanker.factory.DaoFactory" %>
<%@ page import="com.hanker.dao.EmployeeDao" %>
<%@ page import="com.hanker.entity.Employee" %><%--
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

<form action="list_add_do.jsp">
    <table>
        <tr>
            <td>员工编号</td>
            <td><input type="text" name="employeeId"></td>
        </tr>
        <tr>
            <td>员工姓氏</td>
            <td>
                <input type="text" name="firstname">
            </td>
        </tr>
        <tr>
            <td>员工名字</td>
            <td>
                <input type="text" name="lastname">
            </td>
        </tr>
        <tr>
            <td>员工邮箱</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>电话号码</td>
            <td>
            <input type="text" name="phoneNumber">
            </td>
        </tr>
        <tr>
            <td>工作编号</td>
            <td>
            <input type="text" name="jobId">
            </td>
        </tr>
        <tr>
            <td>员工薪水</td>
            <td>
            <input type="text" name="salary">
            </td>
        </tr>
        <tr>
            <td>员工奖金</td>
            <td>
            <input type="text" name="commissionPct">
            </td>
        </tr>
        <tr>
            <td>经理编号</td>
            <td>
                <input type="text" name="managerId">
            </td>
        </tr>
        <tr>
            <td>部门编号</td>
            <td>
            <input type="text" name="departmentId">
            </td>
        </tr>
        <tr>
            <td>雇佣日期</td>
            <td>
            <input type="text" name="hireDate">
            </td>
        </tr>

    </table>
        <input type="submit" value="提交"><br>
        <input type="reset"value="重置">
</form>
</body>
</html>
