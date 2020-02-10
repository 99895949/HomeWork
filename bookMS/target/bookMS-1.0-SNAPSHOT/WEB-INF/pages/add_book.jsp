<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息添加</title>
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
    <form action="${pageContext.request.contextPath}/book/add" method="post">
        <div class="form-group">
            <label for="name">书名</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="请输入书名">
        </div>
        <div class="form-group">
            <label for="author">作者</label>
            <input type="text" class="form-control" name="author" id="author"  placeholder="请输入作者名">
        </div>
        <div class="form-group">
            <label for="publish">出版社</label>
            <input type="text" class="form-control"  name="publish" id="publish"  placeholder="请输入出版社">
        </div>
        <div class="form-group">
            <label for=""isbn">"isbn</label>
            <input type="text" class="form-control" name=""isbn" id=""isbn"  placeholder="请输入"isbn">
        </div>
        <div class="form-group">
            <label for="price">价格</label>
            <input type="text" class="form-control"  name="price"  id="price" placeholder="请输入价格">
        </div>

        <input id="addbook" type="button" value="添加" class="btn btn-success" style="display: inline-block;width: 49%;margin: 0 auto;">
        <input type="reset" value="重置" class="btn btn-fail" style="display: inline-block;width: 49%;margin: 0 auto;">
        <script>
            function mySubmit(flag){
                return flag;
            }
            $("#addbook").click(function () {
                if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#"isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubdate").val()==''||$("#classId").val()==''||$("#pressmark").val()==''||$("#state").val()==''){
                    alert("请填入完整图书信息！");
                    return mySubmit(false);
                }else{
                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/book/add",
                        headers:{
                            "Content-Type": "application/json;charset=utf-8",
                        },
                        data: JSON.stringify({
                            "name": $("#name").val(),
                            "author": $("#author").val(),
                            "publisher": $("#publish").val(),
                            "price": $("#price").val(),
                            ""isbn": $("#"isbn").val(),
                            "borrow": 0
                        }),
                        success: function (data) {
                            if(data){
                                alert("添加成功");
                                window.location.href="${pageContext.request.contextPath}/page/all_book_page";
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



</body>
</html>
