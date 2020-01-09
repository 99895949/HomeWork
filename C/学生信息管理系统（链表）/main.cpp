#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct STUDENT  //ѧ����Ϣ�ṹ���
{
    char id[20];     //ѧ��
    char grade[20];  //�꼶
    char name[20];   //����
    char sex[20];    //�Ա�
    char clas[20];    //�༶
    char subject[20];  //�����
    STUDENT *next;   //ָ����һ��
} STUDENT, *pSTUDENT;
pSTUDENT head = NULL;

void menu() {
    printf("===========================================================\n");
    printf("--------------Ӧ�����Ա�ʵ��ѧ��ѧ���ǼǱ�-----------------\n");
    printf("===========================================================\n");
    printf("1. ¼����ѧ����Ϣ\n");
    printf("2. ����ѧ����Ϣ\n");
    printf("3. ɾ��ѧ����Ϣ\n");
    printf("4. �˳�\n");
    printf("�������Ӧ���ܵ����֣�");
}


void StuInuput()  //��Ϣ¼��
{
    //��������
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
    //����Ϣ¼������
    printf("\n> 1. ��Ϣ¼��ѡ��\n");

    printf("1> ѧ��: ");
    scanf("%s", pNode->id);

    printf("2> �꼶: ");
    scanf("%s", pNode->grade);

    printf("3> ����: ");
    scanf("%s", pNode->name);

    printf("4> �Ա�: ");
    scanf("%s", pNode->sex);

    printf("5> �༶: ");
    scanf("%s", pNode->clas);

    printf("6> �����: ");
    scanf("%s", pNode->subject);
    printf("> Succeed.\n\n");
}

void StuFind()  //����ѧ����Ϣ
{
    char buf[40];
    pSTUDENT pNode = head;
    printf("\n> 2. ��ѡ�������Ŀ\n\n");
    printf("1> ȫ������\n");
    printf("2> ѧ�Ų���\n");
    printf("3> �꼶����\n");
    printf("4> ��������\n");
    printf("5> �Ա����\n");
    printf("6> �༶����\n");
    printf("7> ����Ʋ���\n");
    printf("8> ����\n");
    printf("��������Ӧ���>>");
    int n, count = 0, flag;
    scanf("%d", &n);  //ѡ���Ӧ����

    if (n == 1)//��������Ϣ��ӡ����
    {
        printf("ѧ��\t �꼶\t ����\t �Ա�\t �༶\t �����\n");
        while (pNode) {
            printf("%s\t%s\t%s\t%s\t%s\t%s\n", pNode->id, pNode->grade, pNode->name, pNode->sex, pNode->clas,
                   pNode->subject);
            pNode = pNode->next;
            ++count;
        }
        printf("������ϣ����� %d ������¼ \n\n", count);
    } else if (n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7)//����ѡ�����ֽ��ж�flag��ֵ�������ж�
    {
        char *str[6] = {"ID", "Grade", "Name", "Sex", "Class", "Subject"};
        printf("%s >> ", str[n - 2]);
        scanf("%s", buf);
        printf("ID\t GRADE\t NAME\t SEX\t CLASS\t SUBJECT\n");
        while (pNode) {
            flag = 0;
            if (n == 2 && (strcmp(buf, pNode->id) == 0)) //ѧ�Ų���
            {
                flag = 1;
            } else if (n == 3 && (strcmp(buf, pNode->grade) == 0))//�꼶����
            {
                flag = 1;
            } else if (n == 4 && (strcmp(buf, pNode->name) == 0))//��������
            {
                flag = 1;
            } else if (n == 5 && (strcmp(buf, pNode->sex) == 0))//�Ա����
            {
                flag = 1;
            } else if (n == 6 && (strcmp(buf, pNode->clas) == 0))//�༶����
            {
                flag = 1;
            } else if (n == 7 && (strcmp(buf, pNode->subject) == 0))//����Ʋ���
            {
                flag = 1;
            }

            if (flag == 1)//�ж�flag����ӡ��ѯ
            {
                printf("%s\t%s\t%s\t%s\t%s\t%s\n", pNode->id, pNode->grade, pNode->name, pNode->sex, pNode->clas,
                       pNode->subject);
                ++count;
            }
            pNode = pNode->next;
        }
        printf("������ϣ����� %d ������¼ \n\n", count);
    }
}

void StuDelete() //ɾ������
{
    char buf[40];
    pSTUDENT pNode = head, pt;
    printf("\n> 3. ɾ��ѡ��\n\n");
    printf("1> ȫ��ɾ��\n");
    printf("2> ��ѧ��ɾ��\n");
    printf("3> ���꼶ɾ��\n");
    printf("4> ������ɾ��\n");
    printf("5> ���Ա�ɾ��\n");
    printf("6> ���༶ɾ��\n");
    printf("7> �������ɾ��\n");
    printf("8> ����\n");
    printf("��������Ӧ���>>");
    int n, count = 0, flag;
    scanf("%d", &n);
    printf("\n");
    if (n == 1)//ȫ��ɾ��
    {
        while (pNode) {
            pt = pNode->next;
            free(pNode);
            pNode = pt;
            ++count;
        }
        head = NULL;
        printf("�� %d ������Ϣ��ɾ�� \n\n", count);
    } else if (n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7) {
        char *str[6] = {"ID", "Grade", "Name", "Sex", "Class", "Subject"};
        printf("%s >> ", str[n - 2]);
        scanf("%s", buf);

        pt = head;
        while (pNode) {
            flag = 0;
            if (n == 2 && (strcmp(buf, pNode->id) == 0))//��ѧ��ɾ��
            {
                flag = 1;
            } else if (n == 3 && (strcmp(buf, pNode->grade) == 0))//���꼶ɾ��
            {
                flag = 1;
            } else if (n == 4 && (strcmp(buf, pNode->name) == 0))//������ɾ��
            {
                flag = 1;
            } else if (n == 5 && (strcmp(buf, pNode->sex) == 0))//���Ա�ɾ��
            {
                flag = 1;
            } else if (n == 6 && (strcmp(buf, pNode->clas) == 0))//���༶ɾ��
            {
                flag = 1;
            } else if (n == 7 && (strcmp(buf, pNode->subject) == 0))//�������ɾ��
            {
                flag = 1;
            }
            if (flag == 1)//ɾ������
            {
                if (pNode == head) {
                    pt = pNode->next;
                    head = pt;
                } else {
                    pt->next = pNode->next;
                }

                free(pNode);
                pNode = pt;
                ++count; //��¼ɾ������
            }
            pt = pNode;
            pNode = pNode->next;
        }
        printf("�� %d ������Ϣ��ɾ�� \n\n", count);
    }
}

void freeNode()//��������
{
    pSTUDENT pNode = head, pnext;

    while (pNode) {
        pnext = pNode->next;
        free(pNode);
        pNode = pnext;
    }
    head = NULL;
}

void main()//������
{
    int n = 0;
    while (n != 4) {
        menu();
        scanf("%d", &n);

        switch (n) {
            case 1:
                StuInuput();//��Ӳ���
                break;
            case 2:
                StuFind();//���ҳ�����
                break;
            case 3:
                StuDelete();//ɾ������
                break;
        }
    }
    freeNode();//����
}