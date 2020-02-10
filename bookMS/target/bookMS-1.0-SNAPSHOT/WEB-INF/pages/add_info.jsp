<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加日志</title>
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

<div style="position: relative;top: 10%;width: 40%;margin:0 auto">
    <form action="/book/add" method="post">
        <div class="form-group">
            <label for="id">学号</label>
            <input type="text" class="form-control" name="id" id="id" placeholder="请输入书号">
        </div>
        <div class="form-group">
            <label for=""isbn">"isbn</label>
            <input type="text" class="form-control" name=""isbn" id=""isbn"  placeholder="请输入"isbn号">
        </div>

        <input id="addinfo" type="button" value="添加" class="btn btn-success" style="display: inline-block;width: 49%;margin: 0 auto;">
        <input type="reset" value="重置" class="btn btn-fail" style="display: inline-block;width: 49%;margin: 0 auto;">
        <script>
            function mySubmit(flag){
                return flag;
            }
            $("#addinfo").click(function () {
                if($("#id").val()==''||$("#"isbn").val()==''){
                    alert("请填入完整日志信息！");
                    return mySubmit(false);
                }else{
                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/book/lend",
                        headers:{
                            "Content-Type": "application/json;charset=utf-8",
                        },
                        data: JSON.stringify({
                            "sid": $("#id").val(),
                            ""isbn": $("#"isbn").val()
                        }),
                        success: function (data) {
                            if(data){
                                alert("添加成功");
                                window.location.href="${pageContext.request.contextPath}/page/admin_lend";
                            }else{
                                alert(""isbn号或学号输入错误，添加失败");
                            }
                        }
                    });
                }
            })
        </script>
    </form>

</div>



</body>
</html>
