<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>更改密码</title>
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
<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 25%;width: 45%;">
    <div class="panel panel-primary ">
        <div class="panel-heading">
            <h3 class="panel-title">密码修改</h3>
        </div>
        <div class="panel-body">
            <form  class="form-inline" id="repasswd">
                <div class="input-group">
                    <input type="password" id="oldPasswd" name="oldPasswd" placeholder="输入旧密码" class="form-control"
                           class="form-control">
                    <input type="password" id="newPasswd" name="newPasswd" placeholder="输入新密码" class="form-control"
                           class="form-control">
                    <input type="password" id="reNewPasswd" name="reNewPasswd" placeholder="再次输入新密码"
                           class="form-control" class="form-control">
                    <em id="tishi" style="color: red"></em>
                    <br />
                    <span style="display: block;width: 50%;margin: 0 auto;margin-top: 10px;">
                            <input id="changePassword" type="button" value="提交" class="btn btn-success" style="display: inline-block;width:45%">
                            <input type="reset" value="重置" class="btn btn-fail" style="display: inline-block;width:45%">
                        </span>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function mySubmit(flag) {
        return flag;
    }

    $(document).keyup(function () {
        if ($("#newPasswd").val() != $("#reNewPasswd").val() && $("#newPasswd").val() != "" && $("#reNewPasswd").val() != "" && $("#newPasswd").val().length == $("#reNewPasswd").val().length) {
            $("#tishi").text("两次输入的新密码不同，请检查");
        }
        else {
            $("#tishi").text("");
        }
    })

    $("#changePassword").click(function () {
        if ($("#oldPasswd").val() == '' || $("#newPasswd").val() == '' || $("#reNewPasswd").val() == '') {
            $("#tishi").text("请填写完毕后提交");
            return mySubmit(false);
        }
        else if ($("#newPasswd").val() != $("#reNewPasswd").val()) {
            $("#tishi").text("两次输入的新密码不同，请检查");
            return mySubmit(false);
        }else{
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/admin/update",
                headers:{
                    "Content-Type": "application/json;charset=utf-8",
                },
                data: JSON.stringify({
                    "oldPasswd": $("#oldPasswd").val(),
                    "newPasswd": $("#newPasswd").val()
                }),
                success: function (data) {
                    if(data){
                        alert("修改成功");
                        window.location.href="${pageContext.request.contextPath}/index.jsp";
                    }else{
                        alert("修改失败");
                    }
                }
            });
        }
    })
</script>

</body>

</html>