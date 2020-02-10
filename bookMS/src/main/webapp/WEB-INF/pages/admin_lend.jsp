<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>未还日志</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script>
        //Thu Aug 18 20:38:54 CST 2016
        function getTaskTime(dateString) {

        };

        function ruturnBook(sid,bookid,sname,bookname,"isbn,begintime) {
            var sb = {
                sid:sid,
                bookid:bookid,
                sname:sname,
                bookname:bookname,
                "isbn:"isbn,
                begintime:begintime
            };
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/book/return",
                headers:{
                    "Content-Type": "application/json;charset=utf-8",
                },
                data: JSON.stringify(sb),
                dataType: "json",
                success: function (data) {
                    if(data){
                        alert("归还成功");
                        window.location.href="${pageContext.request.contextPath}/page/admin_lend";
                    }else{
                        alert("归还失败，服务器内部错误");
                    }

                }
            });
        }
    </script>
    <style>
        body {
            background-color: rgb(240, 242, 245);
        }
    </style>

</head>

<body>
<%@ include file="components/header.jsp" %>


<div style="padding: 70px 550px 10px">
    <%--<form method="post" action="querybook.html" class="form-inline" id="searchform">--%>
        <%--<div class="input-group">--%>
            <%--<input type="text" placeholder="输入图书名"isbn号" class="form-control" id="search" name="searchWord"--%>
                   <%--class="form-control">--%>
            <%--<span class="input-group-btn">--%>
                    <%--<input type="submit" value="搜索" class="btn btn-default">--%>
                <%--</span>--%>
        <%--</div>--%>
    <%--</form>--%>
    <%--<script>--%>
        <%--function mySubmit(flag) {--%>
            <%--return flag;--%>
        <%--}--%>
        <%--$("#searchform").submit(function () {--%>
            <%--var val = $("#search").val();--%>
            <%--if (val == '') {--%>
                <%--alert("请输入关键字");--%>
                <%--return mySubmit(false);--%>
            <%--}--%>
        <%--})--%>
    <%--</script>--%>
</div>

<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            未还日志
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
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${list}" var="alog">
                <tr>
                    <td>${alog."isbn}</td>
                    <td>${alog.sid}</td>
                    <td>${alog.sname}</td>
                    <td>${alog.bookname}</td>
                    <td><fmt:formatDate value="${alog.begintime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <%--<td><button onclick='ruturnBook(${alog.sid},${alog.bookid},${alog.sname},${alog.bookname},${alog."isbn},${alog.begintime})' type="button" class="btn btn-danger btn-xs">点我还书</button></td>--%>
                    <td><button onclick='ruturnBook("${alog.sid}","${alog.bookid}","${alog.sname}","${alog.bookname}","${alog."isbn}","${alog.begintime}")' type="button" class="btn btn-danger btn-xs">点我还书</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>

</html>
