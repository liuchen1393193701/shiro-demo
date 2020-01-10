<%--
  Created by IntelliJ IDEA.
  User: qq139
  Date: 2020/1/9
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            font-size: 13px;
        }
        .pager{
            position: relative;

        }
       .pager ul{
            position: absolute;
            right: 200px;
        }
        li{
            float: left;
            margin-left: 5px;
            list-style: none;
        }
        a{
            text-decoration: none;
        }
        table{
            width: 70%;
            margin-right: 150px;
            margin-left: 30px;
        }
    </style>
    <script type="text/javascript">
        function goPage(page) {
            window.location.href="<%=request.getContextPath()%>/user/goList.html?currentPage="+page;
        }
        function assignRole(userId) {
            window.location.href="<%=request.getContextPath()%>/user/goUserRoles.html?userId="+userId;
        }
    </script>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <td>序号</td>
        <td>用户名</td>
        <td>描述</td>
        <td>操作</td>
    </tr>
    <c:forEach var="user" items="${requestScope.userList}" varStatus="i">
    <tr>
        <td>${i.index+1}</td>
        <td>${user.userName}</td>
        <td>${user.bz}</td>
        <td><a href="javascript:assignRole(${user.id})">分配角色</a></td>
    </tr>
    </c:forEach>
</table>
<div class="pager">
    <ul>
        <li>当前${currentPage}/${currentPages}</li>
        <li>共${count}条记录</li>
        <li><a href="javascript:goPage(1)">首页</a></li>
        <li><a href="javascript:goPage(${currentPage-1})">上一页</a></li>
        <li><a href="javascript:goPage(${currentPage+1})">下一页</a></li>
        <li><a href="javascript:goPage(${totalPages})">尾页</a></li>
    </ul>
</div>
</body>
</html>
