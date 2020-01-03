def showInfo():
    print("-"*30)
    print("     学生管理系统  ")
    print(" 1.添加学生的信息")
    print(" 2.删除学生的信息")
    print(" 3.修改学生的信息")
    print(" 4.查询学生的信息")
    print(" 5.遍历所有学生的信息")
    print(" 6.存储学生信息到txt文件中")
    print(" 0.退出系统")
    print( '-'*30)

def student2str(student):
    return "学号：%s,姓名：%s,年龄:%s"%(student['stuId'],student['stuName'],student['stuAge'])

def store(studentList):
    f = open("student.txt","w")
    for student in studentList:
        f.writelines(student2str(student)+"\n")
    f.close()
    print("保存完成，所有学生信息已经存储到student.txt中")

 
#定义一个列表，用来存储多个学生的信息
students=[]
 
while True:
    #把功能列表进行显示给用户
    showInfo()
 
    #提示用户选择功能
    #获取用户选择的功能
    key = int(input("请选择功能（序号）："))
 
    #根据用户选择，完成相应功能
    if key == 1:
        print("您选择了添加学生信息功能")
        stuName = input("请输入学生姓名：")
        stuId = input("请输入学生学号(学号不可重复)：")
        stuAge = input("请输入学生年龄:")
 
        #验证学号是否唯一
        i = 0
        leap = 0
        for stu in students:
            if stu['stuId'] == stuId:
                leap = 1
                break
            else:
                i = i + 1
        if leap == 1:
            print("输入学生学号重复，添加失败！")
        else:
            # 定义一个字典，存放单个学生信息
            stuInfo = {}
            stuInfo['stuName'] = stuName
            stuInfo['stuId'] = stuId
            stuInfo['stuAge'] = stuAge
 
            # 单个学生信息放入列表
            students.append(stuInfo)
            print("添加成功！")
 
    elif key == 2:
        print("您选择了删除学生功能")
        delId=input("请输入要删除的学生学号:")
        #i记录要删除的下标，leap为标志位，如果找到leap=1，否则为0
        i = 0
        leap = 0
        for stu in students:
           if stu['stuId'] == delId:
                leap = 1
                break
           else:
               i=i+1
        if leap == 0:
            print("没有此学生学号，删除失败！")
        else:
            del students[i]
            print("删除成功！")
 
 
    elif key == 3:
        print("您选择了修改学生信息功能")
        alterId=input("请输入你要修改学生的学号:")
        #检测是否有此学号，然后进行修改信息
        i = 0
        leap = 0
        for stu in students:
            if stu['stuId'] == alterId:
                leap = 1
                break
            else:
                i = i + 1
        if leap == 1:
            while True:
                alterNum=int(input(" 1.修改学号\n 2.修改姓名 \n 3.修改年龄 \n 4.退出修改\n"))
                if alterNum == 1:
                    newId=input("输入更改后的学号:")
                    #修改后的学号要验证是否唯一
                    i = 0
                    leap1 = 0
                    for stu1 in students:
                        if stu1['stuId'] == newId:
                            leap1 = 1
                            break
                        else:
                            i = i + 1
                    if leap1 == 1:
                        print("输入学号不可重复，修改失败！")
                    else:
                        stu['stuId']=newId
                        print("学号修改成功")
                elif alterNum == 2:
                    newName=input("输入更改后的姓名:")
                    stu['stuName'] = newName
                    print("姓名修改成功")
                elif alterNum == 3:
                    newAge=input("输入更改后的年龄:")
                    stu['stuAge'] = newAge
                    print("年龄修改成功")
                elif alterNum == 4:
                    break
                else:
                    print("输入错误请重新输入")
        else:
            print("没有此学号，修改失败！")
    elif key == 4:
        print("您选择了查询学生信息功能")
        searchID=input("请输入你要查询学生的学号:")
        #验证是否有此学号
        i = 0
        leap = 0
        for stu in students:
            if stu['stuId'] == searchID:
                leap = 1
                break
            else:
                i = i + 1
        if leap == 0:
            print("没有此学生学号，查询失败！")
        else:
            print("找到此学生，信息如下：")
            print("学号：%s\n姓名：%s\n年龄：%s\n"%(stu['stuId'],stu['stuName'],stu['stuAge']))
    elif key == 5:
        #遍历并输出所有学生的信息
        print('*'*20)
        print("接下来进行遍历所有的学生信息...")
        print("id      姓名         年龄")
        for stu in students:
            print("%s     %s     %s"%(stu['stuId'],stu['stuName'],stu['stuAge']))
        print("*"*20)
    elif key == 6:
        print('*'*20)
        print("把所有学生信息存储到student.txt文件中...")
        store(students)
    elif key == 0:
        #退出功能
        print("欢迎使用本系统，谢谢")
        break
    else:
        print("您输入有误，请重新输入")