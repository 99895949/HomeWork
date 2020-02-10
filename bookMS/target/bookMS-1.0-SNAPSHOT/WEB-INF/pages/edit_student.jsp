<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20 0020
  Time: 上午 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生信息,学号：${student.id}</title>
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
<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑学生信息,学号:${student.id}</h3>
        </div>
        <div class="panel-body">
            <form>

                <div class="input-group">
                    <span class="input-group-addon">学号</span>
                    <input readonly="readonly" type="text" class="form-control" name="readerId" id="readerId"
                           value="${student.id}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${student.name}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex" value="${student.gender}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">年级</span>
                    <input type="text" class="form-control" name="grade" id="grade" value="${student.grade}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">班级</span>
                    <input type="text" class="form-control" name="class_num" id="class_num" value="${student.class_num}">
                </div>
                <input id="editstudent" type="button" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag) {
                        return flag;
                    }

                    $("#editstudent").click(function () {
                        if ($("#name").val() == '' || $("#class_num").val() == '' || $("#grade").val() == '' || $("#sex").val() == '') {
                            alert("请填入完整学生信息！");
                            return mySubmit(false);
                        } else {
                            $.ajax({
                                type: "POST",
                                url: "${pageContext.request.contextPath}/student/update",
                                headers: {
                                    "Content-Type": "application/json;charset=utf-8",
                                },
                                data: JSON.stringify({
                                    "name": $("#name").val(),
                                    "id": ${student.id},
                                    "grade": $("#grade").val(),
                                    "class_num": $("#class_num").val(),
                                    "gender": $("#sex").val(),
                                }),
                                success: function (data) {
                                    if (data) {
                                        alert("修改成功");
                                        window.location.href = "${pageContext.request.contextPath}/page/all_student_page";
                                    } else {
                                        alert("修改失败");
                                    }
                                }
                            });
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
