<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav  style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="#">图书管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        图书管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/page/all_book">全部图书</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/page/add_book">增加图书</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        读者管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/page/all_student_page">全部读者</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/page/add_student_page">增加读者</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        借还日志
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/page/add_info">增加日志</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/page/admin_lend">未还日志</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/page/admin_lend_all">全部日志</a></li>
                    </ul>
                </li>
                <li >
                    <a href="${pageContext.request.contextPath}/page/admin_password" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;${sessionScope.username}，已登录</a></li>
                <li><a href="${pageContext.request.contextPath}/index.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>