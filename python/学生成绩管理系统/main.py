class Info(object):
    '''
        id int 学生学号
        name string 学生姓名
        grades list 各门课成绩
    '''
    def __init__(self,id,name,grades):
        self.id = id
        self.name = name
        self.grades = grades

    def __str__(self):
        global classNames
        if(len(classNames) != len(self.grades)):
            raise Exception("长度不一致")

        res = "学生学号:%d,学生姓名:%s,"%(self.id,self.name)
        for i in range(0,len(classNames)):
            res = res + "%s成绩:%lf"%(classNames[i],self.grades[i])

        return res

# 课程名称列表 
classNames = []
# 学生成绩列表
infos = []

# 创建课程名称列表
def createClassNames():
    classNameNumber = int(input("请输入要录入的科目数量:"))
    for i in range(0,classNameNumber):
        name = input("请输入第%d门课程名称:"%(i+1))
        classNames.append(name)

# 添加学生成绩信息
def insertInfo():
    global infos
    id = int(input("请输入学生学号:"))
    if(isExist(id)):
        print("添加失败，学号重复")
        return
    else:
        name = input("请输入学生姓名:")
        grades = []
        for classname in classNames:
            grade = (float)(input("请输入%s的成绩:"%classname))
            grades.append(grade)
        info = Info(id,name,grades)
        infos.append(info)
        print("添加成功")

# 删除学生成绩信息
def removeInfo(id):
    global infos
    if(isExist(id) is False):
        print("删除失败，没有此学号")
    else:
        infos = [info for info in infos if info.id != id]
        print("删除成功")


# 修改学生成绩信息
def updateInfo(info):
    global infos
    if(isExist(info.id)):
       for i in infos:
           if(i.id == info.id):
               i.name = info.name
               i.grades = info.grades
               print("修改成功")
    else:
        print("没有此学号，修改失败")

# 查询学生信息
def getInfo(id):
    global infos
    info = [info for info in infos if info.id == id]
    return info[0]

# 检查学号是否存在
def isExist(id):
    global infos
    for info in infos:
        if(info.id == id):
            return True
    return False

# 开始菜单
def menu():
    print("-"*30)
    print(" 学生成绩管理系统")
    print(" 1.添加学生的成绩")
    print(" 2.删除学生的成绩")
    print(" 3.修改学生的成绩")
    print(" 4.查询学生的成绩")
    print(" 5.遍历所有学生的成绩")
    print(" 6.存储信息到txt文件中")
    print(" 0.退出系统")
    print( '-'*30)

# 保存到文件
def store(filename="grades.txt"):
    f = open(filename,"w")
    for info in infos:
        f.writelines(info.__str__())
        f.writelines("\n")
    f.close()
    print("保存完成，所有信息已经存储到%s中"%filename)

# 处理页面
def handle():
    global infos
    while True:
        menu()
        #获取用户选择的功能
        key = int(input("请选择功能(序号):"))
        info = None
        if(key == 1):
            insertInfo()
        elif(key == 2):
            id = int(input("请输入要删除的学生学号:"))
            removeInfo(id)
        elif key == 3:
            id = int(input("请输入你要修改学生的学号:"))
            if(isExist(id)):
                global classNames
                info = getInfo(id)
                submenu = "1.修改姓名"
                for i in range(0,len(classNames)):
                    submenu = submenu + " %d.修改%s成绩"%(i+2,classNames[i])
                submenu = submenu + " %d.退出修改"%(len(classNames)+2)

                while True:
                    alterMenu=int(input("%s\n"%submenu))

                    if(alterMenu == 1):
                        info.name = input("输入更改后的姓名:")
                        updateInfo(info)
                    elif(alterMenu == len(classNames) + 2):
                        break
                    else:
                        index = alterMenu - 2
                        grade = float(input("请输入修改后的%s的成绩:"%(classNames[index])))
                        info.grades[index] = grade
                        updateInfo(info)
            else:
                print("没有此学号")
        elif key == 4:
            id = int(input("请输入你要查询学生的学号:"))
            if(isExist(id) is False):
                print("没有此学号")
            else:
                print("信息如下：")
                print(getInfo(id))
        elif key == 5:
            for info in infos:
                print(info)
        elif key == 6:
            filename = input("请输入要存储的文件名")
            print("把所有信息存储到%s文件中..."%filename)
            store(filename)
        elif key == 0:
            print("欢迎使用本系统，谢谢")
            break
        else:
            print("您输入有误，请重新输入")

            

def main():
    # 先录入几个课程
    createClassNames()
    handle()

if __name__ == "__main__":
    main()
    
    