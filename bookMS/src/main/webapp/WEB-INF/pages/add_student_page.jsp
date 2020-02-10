<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加学生</title>
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
<div class="col-xs-5" style="position: relative;top: 25%;left: 30%;">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">添加学生</h3>
        </div>
        <div class="panel-body">
            <form>
                <div class="input-group">
                    <span  class="input-group-addon">学号</span>
                    <input  type="text" class="form-control" name="id" id="id">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name"  >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">年级</span>
                    <input type="text" class="form-control" name="grade" id="grade"  >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">班级</span>
                    <input type="text" class="form-control" name="class_num" id="class_num"  >
                </div>
                <input id="addstudent" type="button" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addstudent").click(function () {
                        if($("#name").val()==''||$("#sex").val()==''||$("#grade").val()==''||$("#class_num").val()==''||$("#id").val()==''){
                            alert("请填入完整学生信息！");
                            return;
                        }else{
                            $.ajax({
                                type: "POST",
                                url: "${pageContext.request.contextPath}/student/add",
                                headers:{
                                    "Content-Type": "application/json;charset=utf-8",
                                },
                                data: JSON.stringify({
                                    "name": $("#name").val(),
                                    "id": $("#id").val(),
                                    "grade": $("#grade").val(),
                                    "class_num": $("#class_num").val(),
                                    "gender": $("#sex").val(),
                                }),
                                success: function (data) {
                                    if(data){
                                        alert("添加成功");
                                        window.location.href="${pageContext.request.contextPath}/page/all_student_page";
                                    }else{
                                        alert("添加失败");
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

