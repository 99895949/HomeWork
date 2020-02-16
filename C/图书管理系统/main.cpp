#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    // ͼ��id
    char bookid[100];
    // ͼ������
    char bookname[100];
    // ����
    char author[100];
    // �����
    int categoryId;
    // ������
    char publisher[100];
    // ����ʱ��
    char publishTime[100];
    // ״̬ 0��ʾ�ڹݣ�1��ʾ���
    int status;
} Book;

typedef struct {
    // ѧ��id
    char studentId[100];
    // ѧ������
    char studentName[100];
} Student;

typedef struct {
    // ͼ��id
    char bookid[100];
    // ѧ��id
    char studentId[100];
    // ����ʱ��
    char beginTime[100];
    // �黹ʱ��
    char endTime[100];
} Info;


Student students[100];
int studentSize = 0;

Book books[100];
int bookSize = 0;

Info infos[100];
int infoSize = 0;


/*ͼ����ز�����ʼ*/

// �ж�id�Ƿ��ظ�
bool isRepeatedBookId(char id[]) {
    bool flag = false;
    for (int i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            return true;
        }
    }
    return flag;
}

// ����ͼ��
void addBook(Book book) {
    books[bookSize++] = book;
}

// ��ӡͼ����Ϣ
void printBookInfo(Book book) {
    printf("id:%s,����:%s,����%s,�����:%d,������:%s,����ʱ��:%s,״̬:", book.bookid, book.bookname, book.author, book.categoryId,
           book.publisher, book.publishTime);
    if (book.status == 0) {
        printf("�ڿ�\n");
    } else {
        printf("���\n");
    }
}

// ����id��ȡͼ��
void findBookById() {
    char id[100];
    printf("���������id:");
    scanf("%s", id);
    for (int i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            printBookInfo(books[i]);
            return;
        }
    }
    printf("û���ҵ�����Ҫ�����");
}

// ����id�޸�ͼ��
void updateBook() {
    printf("������Ҫ�޸ĵ����ID:");
    char id[100];
    scanf("%s", &id);
    for (int i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            printf("����������:");
            scanf("%s", &books[i].bookname);
            printf("����������:");
            scanf("%s", &books[i].author);
            printf("����������:");
            scanf("%d", &books[i].categoryId);
            printf("�����������:");
            scanf("%s", &books[i].publisher);
            printf("���������ʱ��:");
            scanf("%s", &books[i].publishTime);
            printf("�޸ĳɹ�");
            printf("�޸ĺ����Ϣ���£�");
            printBookInfo(books[i]);
            return;
        }
    }
}

// ����idɾ��ͼ��
void deleteBookById() {
    char id[100];
    printf("���������id:");
    scanf("%s", id);
    int index = -1;
    int i = 0;
    for (i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            index = i;
        }
    }

    if (index == -1) {
        printf("û���ҵ�IDΪ%s����", id);
    } else {
        for (i = index; i < bookSize - 1; i++) {
            books[i] = books[i + 1];
        }
        bookSize--;
        printf("ɾ���ɹ�");
    }

}

// ��ӡ����ͼ��
void printAllBooks() {
    printf("һ����%d����\n", bookSize);
    for (int i = 0; i < bookSize; i++) {
        printBookInfo(books[i]);
    }
}

// ����һ����
Book createBook(char bookid[], char bookname[], char author[], char publisher[], char publishTime[], int categoryId) {
    Book book;
    strcpy(book.bookid, bookid);
    strcpy(book.author, author);
    strcpy(book.bookname, bookname);
    strcpy(book.publisher, publisher);
    strcpy(book.publishTime, publishTime);
    book.categoryId = categoryId;
    book.status = 0;
    return book;
}

// ͼ�鱣�浽�ļ�
void saveBookToFile() {
    FILE *f;
    char path[100];
    printf("�����뱣���·��:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ID\t����\t����\t�����\t������\t����ʱ��");
    for (i = 0; i < bookSize; i++) {
        fprintf(f, "%c", '\n');
        fprintf(f, "%s\t", books[i].bookid);
        fprintf(f, "%s\t", books[i].bookname);
        fprintf(f, "%s\t", books[i].author);
        fprintf(f, "%d\t", books[i].categoryId);
        fprintf(f, "%s\t", books[i].publisher);
        fprintf(f, "%s\t", books[i].publishTime);
    }
    fclose(f);
    printf("ͼ���Ѿ�����ɹ�");
}

void bookInit() {
    addBook(createBook("001", "���μ�", "��ж�", "������ѧ������", "1998-02-03", 2));
    addBook(createBook("002", "��������", "��ж�", "�廪���׳�����", "1999-02-03", 2));
    addBook(createBook("003", "ˮ䰴�", "��ж�", "�Ͽ���ѧ������", "2000-02-03", 2));
    addBook(createBook("004", "��¥��", "��ж�", "����ѧ������", "2001-02-03", 2));
}
/*ͼ����ز�������*/
/*ѧ����ز�����ʼ*/

// ѧ��id�Ƿ��ظ�
bool isRepeatedStudentId(char id[]) {
    bool flag = false;
    for (int i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            return true;
        }
    }
    return false;
}

// ��ӡѧ����Ϣ
void printStudentInfo(Student student) {
    printf("id:%s,����:%s\n", student.studentId, student.studentName);
}

// ����ѧ����Ϣ
void addStudent(Student student) {
    students[studentSize++] = student;
}

// �޸�ѧ����Ϣ
void updateStudent() {
    char id[100];
    printf("������ѧ��id:");
    scanf("%s", id);
    int i = 0;
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            printf("������ѧ������:");
            scanf("%s", &students[i].studentName);
            printf("�޸ĳɹ�");
            printStudentInfo(students[i]);
            return;
        }
    }
    if (i == studentSize) {
        printf("û�в�ѯ��idΪ%s��ѧ��", id);
    }
}

// ����id����ѧ����Ϣ
void findStudentById() {
    char id[100];
    printf("������ѧ��id:");
    scanf("%s", id);
    int i = 0;
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            printStudentInfo(students[i]);
            return;
        }
    }
    if (i == studentSize) {
        printf("û�в�ѯ��idΪ%s��ѧ��", id);
    }
}

// ����idɾ��ѧ����Ϣ
void deleteStudentById() {
    char id[100];
    printf("������ѧ��id:");
    scanf("%s", id);
    int index = -1;
    int i = 0;
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            index = i;
        }
    }

    if (index == -1) {
        printf("û���ҵ�idΪ%s��ѧ��", id);
    } else {
        for (i = index; i < studentSize - 1; i++) {
            students[i] = students[i + 1];
        }
        studentSize--;
        printf("ɾ���ɹ�");
    }
}

// ��ӡ����ѧ��
void printAllStudents() {
    printf("һ����%d��ѧ��\n", studentSize);
    for (int i = 0; i < studentSize; ++i) {
        printStudentInfo(students[i]);
    }
}

// ѧ�����浽�ļ�
void saveStudentToFile() {
    FILE *f;
    char path[100];
    printf("�����뱣���·��:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ID\t����\t");
    for (i = 0; i < studentSize; i++) {
        fprintf(f, "%c", '\n');
        fprintf(f, "%s\t", students[i].studentId);
        fprintf(f, "%s\t", students[i].studentName);
    }
    fclose(f);
    printf("ѧ���Ѿ�����ɹ�");
}

Student createStudent(char studentId[],char studentName[]){
    Student student;
    strcpy(student.studentId,studentId);
    strcpy(student.studentName,studentName);
    return student;
}

void studentInit(){
    addStudent(createStudent("01","�ŷ�"));
    addStudent(createStudent("02","����"));
    addStudent(createStudent("03","�ܲ�"));
    addStudent(createStudent("04","���"));
}
/*ѧ����ز�������*/

/*������Ϣ��ز�����ʼ*/
// ����
void borrowBook() {
    char bookId[100];
    printf("������ͼ��Id:");
    scanf("%s", bookId);
    int i = 0;
    for (i = 0; i < bookSize; ++i) {
        if (strcmp(bookId, books[i].bookid) == 0) {
            // �����
            if (books[i].status == 1) {
                // ����û�б����ȥ
                printf("idΪ%s�����Ѿ����ȥ�ˣ�����ʧ��", bookId);
                return;
            } else {
                break;
            }
        }
    }

    if (i == bookSize) {
        printf("û���ҵ�idΪ%s��ͼ��", bookId);
    }


    char studentId[100];
    printf("������ѧ��Id:");
    scanf("%s", studentId);
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(studentId, students[i].studentId) == 0) {
            Info info;
            strcpy(info.studentId, studentId);
            strcpy(info.bookid, bookId);
            printf("���������ʱ��");
            scanf("%s", &info.beginTime);
            strcpy(info.endTime, "");
            infos[infoSize++] = info;

            // �ı����״̬
            for (int j = 0; j < bookSize; ++j) {
                if (strcmp(bookId, books[j].bookid) == 0) {
                   books[j].status = 1;
                }
            }

            printf("���ĳɹ�");
            break;
        }
    }
    if (i == studentSize) {
        printf("û���ҵ�idΪ%s��ѧ��", studentId);
    }


}

// ����
void returnBook() {
    char bookId[100];
    char studentId[100];
    char beginTime[100];
    printf("������ͼ��ID");
    scanf("%s",bookId);
    printf("������ѧ��ID");
    scanf("%s",studentId);
    printf("���������ʱ��");
    scanf("%s",beginTime);
    int i;
    for (i = 0; i < infoSize; ++i) {
        if(strcmp(infos[i].bookid,bookId) == 0 && strcmp(infos[i].studentId,studentId) == 0 && strcmp(infos[i].beginTime,beginTime) == 0){
            printf("������黹ʱ��");
            scanf("%s",infos[i].endTime);
            printf("�黹�ɹ�");
            break;
        }
    }
    if(i == infoSize){
        printf("û���ҵ����ļ�¼");
        return;
    }
}

// ��ӡ������Ϣ
void printInfo(Info info){
    printf("ͼ��id:%s,ѧ��:%s,����ʱ��:%s,����ʱ��:%s\n",info.bookid,info.studentId,info.beginTime,info.endTime);
}

// ��ӡ���н�����Ϣ
void printAllInfo(){
    printf("һ����%d����¼\n", infoSize);
    for (int i = 0; i < infoSize; ++i) {
        printInfo(infos[i]);
    }
}

// ������Ϣ���浽�ļ�
void saveInfoToFile() {
    FILE *f;
    char path[100];
    printf("�����뱣���·��:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ѧ��ID\tͼ��ID\t����ʱ��\t�黹ʱ��");
    for (i = 0; i < infoSize; i++) {
        fprintf(f, "%c", '\n');
        fprintf(f, "%s\t", infos[i].studentId);
        fprintf(f, "%s\t", infos[i].bookid);
        fprintf(f, "%s\t", infos[i].beginTime);
        fprintf(f, "%s\t", infos[i].endTime);
    }
    fclose(f);
    printf("������Ϣ�Ѿ�����ɹ�");
}

/*������Ϣ��ز�������*/



int main() {

    bookInit();
    studentInit();

    while (1) {
        printf("\n");
        printf("1.����ͼ��\n");
        printf("2.ɾ��ͼ��\n");
        printf("3.�޸�ͼ��\n");
        printf("4.��ѯͼ��\n");
        printf("5.����ͼ��\n");
        printf("6.ͼ�鱣�浽�ļ�\n");
        printf("7.����ѧ��\n");
        printf("8.ɾ��ѧ��\n");
        printf("9.�޸�ѧ��\n");
        printf("10.��ѯѧ��\n");
        printf("11.����ѧ��\n");
        printf("12.ѧ�����浽�ļ�\n");
        printf("13.����ͼ��\n");
        printf("14.�黹ͼ��\n");
        printf("15.������־\n");
        printf("16.������־�����ļ�\n");
        printf("0.�˳�ϵͳ\n");
        int menuIndex;
        printf("������:");
        scanf("%d", &menuIndex);
        switch (menuIndex) {
            case 1:
                Book book;
                while (1) {
                    printf("������id:");
                    scanf("%s", &book.bookid);
                    if (isRepeatedBookId(book.bookid)) {
                        printf("id�ظ�������������\n");
                    } else {
                        break;
                    }
                }
                printf("����������:");
                scanf("%s", &book.bookname);
                printf("����������:");
                scanf("%s", &book.author);
                printf("����������:");
                scanf("%d", &book.categoryId);
                printf("�����������:");
                scanf("%s", &book.publisher);
                printf("���������ʱ��:");
                scanf("%s", &book.publishTime);
                book.status = 0;
                addBook(book);
                break;
            case 2:
                deleteBookById();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                findBookById();
                break;
            case 5:
                printAllBooks();
                break;
            case 6:
                saveBookToFile();
                break;
            case 7:
                Student student;
                while (1) {
                    printf("������ѧ��id:");
                    scanf("%s", student.studentId);
                    if (isRepeatedStudentId(student.studentId)) {
                        printf("id�ظ�������������\n");
                    } else {
                        break;
                    }
                }

                printf("������ѧ������:");
                scanf("%s", student.studentName);
                addStudent(student);
                break;
            case 8:
                deleteStudentById();
                break;
            case 9:
                updateStudent();
                break;
            case 10:
                findStudentById();
                break;
            case 11:
                printAllStudents();
                break;
            case 12:
                saveStudentToFile();
                break;
            case 13:
                borrowBook();
                break;
            case 14:
                returnBook();
                break;
            case 15:
                printAllInfo();
                break;
            case 16:
                saveInfoToFile();
                break;
            case 0:
                printf("��лʹ�ã������˳�");
                exit(0);
                break;
        }
    }


    return 0;
}
