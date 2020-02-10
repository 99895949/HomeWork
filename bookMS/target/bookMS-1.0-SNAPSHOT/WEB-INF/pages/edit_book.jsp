<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑图书</title>
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

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑《${book.name}》</h3>
        </div>
        <div class="panel-body">
            <form action="book_edit_do.html?id=${book.id}" method="post" id="addbook" >

                <div class="input-group">
                    <span  class="input-group-addon">书名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${book.name}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">作者</span>
                    <input type="text" class="form-control" name="author" id="author" value="${book.author}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="publish" id="publish"  value="${book.publisher}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">"isbn</span>
                    <input type="text" class="form-control" name=""isbn" id=""isbn"  value="${book."isbn}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">价格</span>
                    <input type="text" class="form-control" name="price"  id="price" value="${book.price}">
                </div>
                <input id="editbook" type="button" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#editbook").click(function () {
                        if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#"isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubdate").val()==''||$("#classId").val()==''||$("#pressmark").val()==''||$("#state").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }else{
                            $.ajax({
                                type: "POST",
                                url: "${pageContext.request.contextPath}/book/update",
                                headers:{
                                    "Content-Type": "application/json;charset=utf-8",
                                },
                                data: JSON.stringify({
                                    "id":${book.id},
                                    "name": $("#name").val(),
                                    "author": $("#author").val(),
                                    "publisher": $("#publish").val(),
                                    "price": $("#price").val(),
                                    ""isbn": $("#"isbn").val(),
                                    "borrow": 0
                                }),
                                success: function (data) {
                                    if(data){
                                        alert("修改成功");
                                        window.location.href="${pageContext.request.contextPath}/page/all_book_page";
                                    }else{
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

