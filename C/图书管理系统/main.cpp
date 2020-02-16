#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    // 图书id
    char bookid[100];
    // 图书名称
    char bookname[100];
    // 作者
    char author[100];
    // 分类号
    int categoryId;
    // 出版社
    char publisher[100];
    // 出版时间
    char publishTime[100];
    // 状态 0表示在馆，1表示借出
    int status;
} Book;

typedef struct {
    // 学生id
    char studentId[100];
    // 学生姓名
    char studentName[100];
} Student;

typedef struct {
    // 图书id
    char bookid[100];
    // 学生id
    char studentId[100];
    // 借阅时间
    char beginTime[100];
    // 归还时间
    char endTime[100];
} Info;


Student students[100];
int studentSize = 0;

Book books[100];
int bookSize = 0;

Info infos[100];
int infoSize = 0;


/*图书相关操作开始*/

// 判断id是否重复
bool isRepeatedBookId(char id[]) {
    bool flag = false;
    for (int i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            return true;
        }
    }
    return flag;
}

// 增加图书
void addBook(Book book) {
    books[bookSize++] = book;
}

// 打印图书信息
void printBookInfo(Book book) {
    printf("id:%s,书名:%s,作者%s,分类号:%d,出版社:%s,出版时间:%s,状态:", book.bookid, book.bookname, book.author, book.categoryId,
           book.publisher, book.publishTime);
    if (book.status == 0) {
        printf("在库\n");
    } else {
        printf("借出\n");
    }
}

// 根据id获取图书
void findBookById() {
    char id[100];
    printf("请输入书的id:");
    scanf("%s", id);
    for (int i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            printBookInfo(books[i]);
            return;
        }
    }
    printf("没有找到满足要求的书");
}

// 根据id修改图书
void updateBook() {
    printf("请输入要修改的书的ID:");
    char id[100];
    scanf("%s", &id);
    for (int i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            printf("请输入书名:");
            scanf("%s", &books[i].bookname);
            printf("请输入作者:");
            scanf("%s", &books[i].author);
            printf("请输入分类号:");
            scanf("%d", &books[i].categoryId);
            printf("请输入出版社:");
            scanf("%s", &books[i].publisher);
            printf("请输入出版时间:");
            scanf("%s", &books[i].publishTime);
            printf("修改成功");
            printf("修改后的信息如下：");
            printBookInfo(books[i]);
            return;
        }
    }
}

// 根据id删除图书
void deleteBookById() {
    char id[100];
    printf("请输入书的id:");
    scanf("%s", id);
    int index = -1;
    int i = 0;
    for (i = 0; i < bookSize; ++i) {
        if (strcmp(id, books[i].bookid) == 0) {
            index = i;
        }
    }

    if (index == -1) {
        printf("没有找到ID为%s的书", id);
    } else {
        for (i = index; i < bookSize - 1; i++) {
            books[i] = books[i + 1];
        }
        bookSize--;
        printf("删除成功");
    }

}

// 打印所有图书
void printAllBooks() {
    printf("一共有%d本书\n", bookSize);
    for (int i = 0; i < bookSize; i++) {
        printBookInfo(books[i]);
    }
}

// 创建一本书
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

// 图书保存到文件
void saveBookToFile() {
    FILE *f;
    char path[100];
    printf("请输入保存的路径:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ID\t名称\t作者\t分类号\t出版社\t出版时间");
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
    printf("图书已经保存成功");
}

void bookInit() {
    addBook(createBook("001", "西游记", "吴承恩", "北京大学出版社", "1998-02-03", 2));
    addBook(createBook("002", "三国演义", "吴承恩", "清华大圩出版社", "1999-02-03", 2));
    addBook(createBook("003", "水浒传", "吴承恩", "南开大学出版社", "2000-02-03", 2));
    addBook(createBook("004", "红楼梦", "吴承恩", "天津大学出版社", "2001-02-03", 2));
}
/*图书相关操作结束*/
/*学生相关操作开始*/

// 学生id是否重复
bool isRepeatedStudentId(char id[]) {
    bool flag = false;
    for (int i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            return true;
        }
    }
    return false;
}

// 打印学生信息
void printStudentInfo(Student student) {
    printf("id:%s,姓名:%s\n", student.studentId, student.studentName);
}

// 增加学生信息
void addStudent(Student student) {
    students[studentSize++] = student;
}

// 修改学生信息
void updateStudent() {
    char id[100];
    printf("请输入学生id:");
    scanf("%s", id);
    int i = 0;
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            printf("请输入学生姓名:");
            scanf("%s", &students[i].studentName);
            printf("修改成功");
            printStudentInfo(students[i]);
            return;
        }
    }
    if (i == studentSize) {
        printf("没有查询到id为%s的学生", id);
    }
}

// 根据id查找学生信息
void findStudentById() {
    char id[100];
    printf("请输入学生id:");
    scanf("%s", id);
    int i = 0;
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            printStudentInfo(students[i]);
            return;
        }
    }
    if (i == studentSize) {
        printf("没有查询到id为%s的学生", id);
    }
}

// 根据id删除学生信息
void deleteStudentById() {
    char id[100];
    printf("请输入学生id:");
    scanf("%s", id);
    int index = -1;
    int i = 0;
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(id, students[i].studentId) == 0) {
            index = i;
        }
    }

    if (index == -1) {
        printf("没有找到id为%s的学生", id);
    } else {
        for (i = index; i < studentSize - 1; i++) {
            students[i] = students[i + 1];
        }
        studentSize--;
        printf("删除成功");
    }
}

// 打印所有学生
void printAllStudents() {
    printf("一共有%d个学生\n", studentSize);
    for (int i = 0; i < studentSize; ++i) {
        printStudentInfo(students[i]);
    }
}

// 学生保存到文件
void saveStudentToFile() {
    FILE *f;
    char path[100];
    printf("请输入保存的路径:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ID\t姓名\t");
    for (i = 0; i < studentSize; i++) {
        fprintf(f, "%c", '\n');
        fprintf(f, "%s\t", students[i].studentId);
        fprintf(f, "%s\t", students[i].studentName);
    }
    fclose(f);
    printf("学生已经保存成功");
}

Student createStudent(char studentId[],char studentName[]){
    Student student;
    strcpy(student.studentId,studentId);
    strcpy(student.studentName,studentName);
    return student;
}

void studentInit(){
    addStudent(createStudent("01","张飞"));
    addStudent(createStudent("02","刘备"));
    addStudent(createStudent("03","曹操"));
    addStudent(createStudent("04","周瑜"));
}
/*学生相关操作结束*/

/*借阅信息相关操作开始*/
// 借书
void borrowBook() {
    char bookId[100];
    printf("请输入图书Id:");
    scanf("%s", bookId);
    int i = 0;
    for (i = 0; i < bookSize; ++i) {
        if (strcmp(bookId, books[i].bookid) == 0) {
            // 书存在
            if (books[i].status == 1) {
                // 并且没有被借出去
                printf("id为%s的书已经借出去了，借书失败", bookId);
                return;
            } else {
                break;
            }
        }
    }

    if (i == bookSize) {
        printf("没有找到id为%s的图书", bookId);
    }


    char studentId[100];
    printf("请输入学生Id:");
    scanf("%s", studentId);
    for (i = 0; i < studentSize; ++i) {
        if (strcmp(studentId, students[i].studentId) == 0) {
            Info info;
            strcpy(info.studentId, studentId);
            strcpy(info.bookid, bookId);
            printf("请输入借阅时间");
            scanf("%s", &info.beginTime);
            strcpy(info.endTime, "");
            infos[infoSize++] = info;

            // 改变书的状态
            for (int j = 0; j < bookSize; ++j) {
                if (strcmp(bookId, books[j].bookid) == 0) {
                   books[j].status = 1;
                }
            }

            printf("借阅成功");
            break;
        }
    }
    if (i == studentSize) {
        printf("没有找到id为%s的学生", studentId);
    }


}

// 还书
void returnBook() {
    char bookId[100];
    char studentId[100];
    char beginTime[100];
    printf("请输入图书ID");
    scanf("%s",bookId);
    printf("请输入学生ID");
    scanf("%s",studentId);
    printf("请输入借阅时间");
    scanf("%s",beginTime);
    int i;
    for (i = 0; i < infoSize; ++i) {
        if(strcmp(infos[i].bookid,bookId) == 0 && strcmp(infos[i].studentId,studentId) == 0 && strcmp(infos[i].beginTime,beginTime) == 0){
            printf("请输入归还时间");
            scanf("%s",infos[i].endTime);
            printf("归还成功");
            break;
        }
    }
    if(i == infoSize){
        printf("没有找到借阅记录");
        return;
    }
}

// 打印借阅信息
void printInfo(Info info){
    printf("图书id:%s,学号:%s,借阅时间:%s,还书时间:%s\n",info.bookid,info.studentId,info.beginTime,info.endTime);
}

// 打印所有借阅信息
void printAllInfo(){
    printf("一共有%d条记录\n", infoSize);
    for (int i = 0; i < infoSize; ++i) {
        printInfo(infos[i]);
    }
}

// 借阅信息保存到文件
void saveInfoToFile() {
    FILE *f;
    char path[100];
    printf("请输入保存的路径:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "学生ID\t图书ID\t借阅时间\t归还时间");
    for (i = 0; i < infoSize; i++) {
        fprintf(f, "%c", '\n');
        fprintf(f, "%s\t", infos[i].studentId);
        fprintf(f, "%s\t", infos[i].bookid);
        fprintf(f, "%s\t", infos[i].beginTime);
        fprintf(f, "%s\t", infos[i].endTime);
    }
    fclose(f);
    printf("借阅信息已经保存成功");
}

/*借阅信息相关操作结束*/



int main() {

    bookInit();
    studentInit();

    while (1) {
        printf("\n");
        printf("1.增加图书\n");
        printf("2.删除图书\n");
        printf("3.修改图书\n");
        printf("4.查询图书\n");
        printf("5.所有图书\n");
        printf("6.图书保存到文件\n");
        printf("7.增加学生\n");
        printf("8.删除学生\n");
        printf("9.修改学生\n");
        printf("10.查询学生\n");
        printf("11.所有学生\n");
        printf("12.学生保存到文件\n");
        printf("13.借阅图书\n");
        printf("14.归还图书\n");
        printf("15.借阅日志\n");
        printf("16.借阅日志保存文件\n");
        printf("0.退出系统\n");
        int menuIndex;
        printf("请输入:");
        scanf("%d", &menuIndex);
        switch (menuIndex) {
            case 1:
                Book book;
                while (1) {
                    printf("请输入id:");
                    scanf("%s", &book.bookid);
                    if (isRepeatedBookId(book.bookid)) {
                        printf("id重复，请重新输入\n");
                    } else {
                        break;
                    }
                }
                printf("请输入书名:");
                scanf("%s", &book.bookname);
                printf("请输入作者:");
                scanf("%s", &book.author);
                printf("请输入分类号:");
                scanf("%d", &book.categoryId);
                printf("请输入出版社:");
                scanf("%s", &book.publisher);
                printf("请输入出版时间:");
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
                    printf("请输入学生id:");
                    scanf("%s", student.studentId);
                    if (isRepeatedStudentId(student.studentId)) {
                        printf("id重复，请重新输入\n");
                    } else {
                        break;
                    }
                }

                printf("请输入学生姓名:");
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
                printf("感谢使用，程序退出");
                exit(0);
                break;
        }
    }


    return 0;
}
