<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部学生</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    <script>
        function studentEdit(id) {
            window.location.href = "${pageContext.request.contextPath}/page/edit_student?id="+id;
        }
        function studentRemove(id) {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/student/remove/"+id,
                headers:{
                    "Content-Type": "application/json;charset=utf-8",
                },
                success: function (data) {
                    if(data){
                        alert("删除成功");
                        window.location.href="${pageContext.request.contextPath}/page/all_student_page";
                    }else{
                        alert("删除失败");
                    }
                }
            });
        }
    </script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<body>
<%@ include file="components/header.jsp" %>
<div style="position: relative;top: 15%">
</div>

<div class="panel panel-default" style="position:relative;top: 80px;width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            全部学生
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover" >
            <thead>
            <tr>
                <th>学生号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年级</th>
                <th>班级</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="reader">
                <tr>
                    <td><c:out value="${reader.id}"></c:out></td>
                    <td><c:out value="${reader.name}"></c:out></td>
                    <td><c:out value="${reader.gender}"></c:out></td>
                    <td><c:out value="${reader.grade}"></c:out></td>
                    <td><c:out value="${reader.class_num}班"></c:out></td>
                    <td><button onclick="studentEdit(${reader.id})" type="button" class="btn btn-info btn-xs">编辑</button></td>
                    <td><button onclick="studentRemove('${reader.id}')" type="button" class="btn btn-danger btn-xs">删除</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

