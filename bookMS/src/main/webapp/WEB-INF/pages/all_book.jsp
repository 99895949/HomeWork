<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部图书信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>
</head>
<body>
<%@ include file="components/header.jsp" %>
<div style="padding: 70px 550px 10px">
    <%--<form   method="post" action="querybook.html" class="form-inline"  id="searchform">--%>
        <%--<div class="input-group">--%>
            <%--<input type="text" placeholder="输入图书名" class="form-control" id="search" name="searchWord" class="form-control">--%>
            <%--<span class="input-group-btn">--%>
                            <%--<input type="submit" value="搜索" class="btn btn-default">--%>
            <%--</span>--%>
        <%--</div>--%>
    <%--</form>--%>
    <script>
        function mySubmit(flag){
            return flag;
        }
        $("#searchform").submit(function () {
            var val=$("#search").val();
            if(val==''){
                alert("请输入关键字");
                return mySubmit(false);
            }
        })

        function bookEdit(id) {
            window.location.href = "${pageContext.request.contextPath}/page/edit_book?id="+id;
        }
        function bookReturn(id) {
            alert(id);
        }
        function bookRemove(id){
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/book/remove/"+id,
                headers:{
                    "Content-Type": "application/json;charset=utf-8",
                },
                success: function (data) {
                    if(data){
                        alert("删除成功");
                        window.location.href="${pageContext.request.contextPath}/page/all_book_page";
                    }else{
                        alert("删除失败");
                    }
                }
            });
        }
    </script>
</div>
<div style="position: relative;top: 10%">
</div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部图书
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>"isbn</th>
                <th>价格</th>
                <th>状态</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.books}" var="book">
            <tr>
                <td><c:out value="${book.name}"></c:out></td>
                <td><c:out value="${book.author}"></c:out></td>
                <td><c:out value="${book.publisher}"></c:out></td>
                <td><c:out value="${book."isbn}"></c:out></td>
                <td><c:out value="${book.price}"></c:out></td>
                <c:if test="${book.borrow==1}">
                    <td><button class="btn btn-danger btn-xs">借阅中</button></a></td>
                </c:if>
                <c:if test="${book.borrow==0}">
                    <td><button class="btn btn-primary btn-xs">已入库</button></td>
                </c:if>
                <td><button onclick="bookEdit('${book.id}')" type="button" class="btn btn-info btn-xs">编辑</button></td>
                <td><button onclick="bookRemove('${book.id}')" type="button" class="btn btn-danger btn-xs">删除</button></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>

