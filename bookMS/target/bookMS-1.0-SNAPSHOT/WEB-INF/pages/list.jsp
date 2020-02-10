<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/19 0019
  Time: 下午 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is a jsp
<c:forEach items="${list}" var="student">
    ${student.name}
</c:forEach>

</body>
</html>
