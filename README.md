# C/C++
## 学生成绩管理系统（C语言）

    位置：C/学生成绩管理系统


## 学生信息管理系统（C语言链表实现）

    位置：C/学生信息管理系统

    说明：学生(学号,年级,姓名,性别,班级,文理科)信息的增删改查
	
## 图书管理系统

    位置：C/图书管理系统

    说明：图书信息的增删改查，保存文件;学生信息增删改查，保存文件；借阅图书，归还图书，保存文件，没用指针

# Python
## 学生成绩管理系统

    位置：python/学生成绩管理系统

    说明：控制台的增删改查，可以录入任意门课程，存储到文件

## 学生信息管理系统

    位置：python/学生信息管理系统

    说明：学生信息写死了（学号，姓名，年龄），控制台的增删改查，存储到文件

## 段子网爬虫

    位置：python/duanziwang-spyder

    说明：爬虫http://duanziwang.com，并存储到txt文件

# Java
## 豆瓣网爬虫

    位置：Java/douban-spyder

    说明：豆瓣网爬虫，爬取热门电影信息，并保存到txt文件中

## 标准考试系统（GUI）

    位置：Java/exam_sys_gui

    功能：
    1. 根据数据库用户名和密码判断用户是哪个角色，从而打开哪个页面
    2. 普通用户登录后进入答题界面，选择试卷，之后就可以答题了
    3. 管理员用户登录后进入管理员页面（我做的太简单了，实在是GUI不会写），有导入试题到数据库的功能（导入文件的格式具体看template文件夹下有说明），还有一个根据数据库随机生成10份试卷（一份试卷对应一个txt文件）

    说明：
    1. 一个简单的桌面考试系统Demo
    2. 数据库用的MySQL，SQL文件在sql文件夹里，写的仓促好多关联都没写，主要写了答题这部分
    3. JDBC的一些配置 需要在src/util/DBUtils.java里边改(url,username,password)
    4. JDBC jar包在jar文件夹里

## 停车场管理系统

    位置：Java/PARK_SYSTEM

    前端（Vue）：Java/PARK_SYSTEM/CLIENT

    后端（SpringBoot）：Java/PARK_SYSTEM/SERVER

    技术栈：SpringBoot,SpringDataJPA,maven,SpringMVC,Vue,MySQL

    说明：用户管理，车位管理，停车卡管理，入场出场管理等

## 图书管理系统（JSP）

    位置：Java/BOOK_SYSTEM

    技术栈：Spring，SpringMVC，JDBCTemplate，MySQL，maven，JSP

    功能：读者管理（增删改查+分页）、图书管理（增删改查+分页），图书类别没写（懒得写了），借阅管理（借书还书，查看删除）

    说明：可以使用mvn jetty:run 执行

## CMS系统（SSM+layui）

    位置：Java/CMS

    说明：JDK1.8 + Mysql5.5 + Tomcat8

    说明：sql脚本中 我的mysql导入 datetime(0) NULL 报错，我改成了datetime就不报错了

## 员工信息管理系统（SpringBoot+SSM+vue）

    位置：Java/EMPLOYEE_SYSTEM

    说明：JDK1.8 + Mysql5.5 + SpringBoot2.x + Mybatis三剑客

    功能：部门管理，员工管理，考勤管理，系统管理




