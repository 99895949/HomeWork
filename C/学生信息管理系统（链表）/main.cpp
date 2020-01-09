#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct STUDENT  //学生信息结构设计
{
    char id[20];     //学号
    char grade[20];  //年级
    char name[20];   //姓名
    char sex[20];    //性别
    char clas[20];    //班级
    char subject[20];  //文理科
    STUDENT *next;   //指向下一个
} STUDENT, *pSTUDENT;
pSTUDENT head = NULL;

void menu() {
    printf("===========================================================\n");
    printf("--------------应用线性表实现学生学籍登记表-----------------\n");
    printf("===========================================================\n");
    printf("1. 录入新学生信息\n");
    printf("2. 查找学生信息\n");
    printf("3. 删除学生信息\n");
    printf("4. 退出\n");
    printf("请输入对应功能的数字：");
}


void StuInuput()  //信息录入
{
    //创建链表
    pSTUDENT pNode = head;

    if (pNode == NULL) {
        head = (pSTUDENT) malloc(sizeof(STUDENT));
        pNode = head;
        pNode->next = NULL;
    } else {
        while (pNode->next) {
            pNode = pNode->next;
        }
        pNode->next = (pSTUDENT) malloc(sizeof(STUDENT));
        pNode = pNode->next;
        pNode->next = NULL;
    }
    //将信息录入链表
    printf("\n> 1. 信息录入选项\n");

    printf("1> 学号: ");
    scanf("%s", pNode->id);

    printf("2> 年级: ");
    scanf("%s", pNode->grade);

    printf("3> 姓名: ");
    scanf("%s", pNode->name);

    printf("4> 性别: ");
    scanf("%s", pNode->sex);

    printf("5> 班级: ");
    scanf("%s", pNode->clas);

    printf("6> 文理科: ");
    scanf("%s", pNode->subject);
    printf("> Succeed.\n\n");
}

void StuFind()  //查找学生信息
{
    char buf[40];
    pSTUDENT pNode = head;
    printf("\n> 2. 请选择查找项目\n\n");
    printf("1> 全部查找\n");
    printf("2> 学号查找\n");
    printf("3> 年级查找\n");
    printf("4> 姓名查找\n");
    printf("5> 性别查找\n");
    printf("6> 班级查找\n");
    printf("7> 文理科查找\n");
    printf("8> 返回\n");
    printf("请输入相应编号>>");
    int n, count = 0, flag;
    scanf("%d", &n);  //选择对应功能

    if (n == 1)//将所有信息打印出来
    {
        printf("学号\t 年级\t 姓名\t 性别\t 班级\t 文理科\n");
        while (pNode) {
            printf("%s\t%s\t%s\t%s\t%s\t%s\n", pNode->id, pNode->grade, pNode->name, pNode->sex, pNode->clas,
                   pNode->subject);
            pNode = pNode->next;
            ++count;
        }
        printf("查找完毕，共“ %d ”条记录 \n\n", count);
    } else if (n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7)//按所选的数字进行对flag赋值，进行判定
    {
        char *str[6] = {"ID", "Grade", "Name", "Sex", "Class", "Subject"};
        printf("%s >> ", str[n - 2]);
        scanf("%s", buf);
        printf("ID\t GRADE\t NAME\t SEX\t CLASS\t SUBJECT\n");
        while (pNode) {
            flag = 0;
            if (n == 2 && (strcmp(buf, pNode->id) == 0)) //学号查找
            {
                flag = 1;
            } else if (n == 3 && (strcmp(buf, pNode->grade) == 0))//年级查找
            {
                flag = 1;
            } else if (n == 4 && (strcmp(buf, pNode->name) == 0))//姓名查找
            {
                flag = 1;
            } else if (n == 5 && (strcmp(buf, pNode->sex) == 0))//性别查找
            {
                flag = 1;
            } else if (n == 6 && (strcmp(buf, pNode->clas) == 0))//班级查找
            {
                flag = 1;
            } else if (n == 7 && (strcmp(buf, pNode->subject) == 0))//文理科查找
            {
                flag = 1;
            }

            if (flag == 1)//判断flag，打印查询
            {
                printf("%s\t%s\t%s\t%s\t%s\t%s\n", pNode->id, pNode->grade, pNode->name, pNode->sex, pNode->clas,
                       pNode->subject);
                ++count;
            }
            pNode = pNode->next;
        }
        printf("查找完毕，共“ %d ”条记录 \n\n", count);
    }
}

void StuDelete() //删除操作
{
    char buf[40];
    pSTUDENT pNode = head, pt;
    printf("\n> 3. 删除选项\n\n");
    printf("1> 全部删除\n");
    printf("2> 按学号删除\n");
    printf("3> 按年级删除\n");
    printf("4> 按姓名删除\n");
    printf("5> 按性别删除\n");
    printf("6> 按班级删除\n");
    printf("7> 按文理科删除\n");
    printf("8> 返回\n");
    printf("请输入相应编号>>");
    int n, count = 0, flag;
    scanf("%d", &n);
    printf("\n");
    if (n == 1)//全部删除
    {
        while (pNode) {
            pt = pNode->next;
            free(pNode);
            pNode = pt;
            ++count;
        }
        head = NULL;
        printf("“ %d ”条信息已删除 \n\n", count);
    } else if (n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7) {
        char *str[6] = {"ID", "Grade", "Name", "Sex", "Class", "Subject"};
        printf("%s >> ", str[n - 2]);
        scanf("%s", buf);

        pt = head;
        while (pNode) {
            flag = 0;
            if (n == 2 && (strcmp(buf, pNode->id) == 0))//按学号删除
            {
                flag = 1;
            } else if (n == 3 && (strcmp(buf, pNode->grade) == 0))//按年级删除
            {
                flag = 1;
            } else if (n == 4 && (strcmp(buf, pNode->name) == 0))//按姓名删除
            {
                flag = 1;
            } else if (n == 5 && (strcmp(buf, pNode->sex) == 0))//按性别删除
            {
                flag = 1;
            } else if (n == 6 && (strcmp(buf, pNode->clas) == 0))//按班级删除
            {
                flag = 1;
            } else if (n == 7 && (strcmp(buf, pNode->subject) == 0))//按文理科删除
            {
                flag = 1;
            }
            if (flag == 1)//删除操作
            {
                if (pNode == head) {
                    pt = pNode->next;
                    head = pt;
                } else {
                    pt->next = pNode->next;
                }

                free(pNode);
                pNode = pt;
                ++count; //记录删除次数
            }
            pt = pNode;
            pNode = pNode->next;
        }
        printf("“ %d ”条信息已删除 \n\n", count);
    }
}

void freeNode()//结束操作
{
    pSTUDENT pNode = head, pnext;

    while (pNode) {
        pnext = pNode->next;
        free(pNode);
        pNode = pnext;
    }
    head = NULL;
}

void main()//主函数
{
    int n = 0;
    while (n != 4) {
        menu();
        scanf("%d", &n);

        switch (n) {
            case 1:
                StuInuput();//添加操作
                break;
            case 2:
                StuFind();//查找出操作
                break;
            case 3:
                StuDelete();//删除操作
                break;
        }
    }
    freeNode();//结束
}