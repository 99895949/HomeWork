<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>全部日志</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: rgb(240, 242, 245);
        }
    </style>

</head>

<body>
<%@ include file="components/header.jsp" %>


<div style="padding: 70px 550px 10px">
</div>

<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            全部日志
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>图书"isbn号</th>
                <th>学生证号</th>
                <th>学生姓名</th>
                <th>图书名称</th>
                <th>借出日期</th>
                <th>归还日期</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${list_all}" var="alog">
                <tr>
                    <td>${alog."isbn}</td>
                    <td>${alog.sid}</td>
                    <td>${alog.sname}</td>
                    <td>${alog.bookname}</td>
                    <td><fmt:formatDate value="${alog.begintime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${alog.endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>

</html>
