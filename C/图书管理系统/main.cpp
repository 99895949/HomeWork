#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    // 图书id
    int bookid;
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
} Book;

Book books[100];
int size = 0;

void addBook(Book book) {
    books[size++] = book;
}


// 打印图书信息
void printBookInfo(Book book) {
    printf("id:%d,书名:%d,作者%s,分类号:%d,出版社:%s,出版时间:%s\n", book.bookid, book.bookname, book.author, book.categoryId,
           book.publisher, book.publishTime);
}

void findBookById(int id) {
    for (int i = 0; i < size; ++i) {
        if (id == books[i].bookid) {
            printBookInfo(books[i]);
            return;
        }
    }
    printf("没有找到满足要求的书");
}

void updateBook() {
    printf("请输入要修改的书的ID:");
    int id;
    scanf("%d", &id);
    for (int i = 0; i < size; ++i) {
        if (id == books[i].bookid) {
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

void deleteBookById(int id) {
    int index = -1;
    int i = 0;
    for (i = 0; i < size; ++i) {
        if (id == books[i].bookid) {
            index = i;
        }
    }

    if (index == -1) {
        printf("没有找到ID为%d的书", id);
    } else {
        for (i = index; i < size - 1; i++) {
            books[i] = books[i + 1];
        }
        size--;
        printf("删除成功");
    }

}

void printListInfo() {
    printf("一共有%d本书\n", size);
    for (int i = 0; i < size; i++) {
        printBookInfo(books[i]);
    }
}

Book createBook(int bookid, char bookname[], char author[], char publisher[], char publishTime[], int categoryId) {
    Book book;
    book.bookid = bookid;
    strcpy(book.author, author);
    strcpy(book.bookname, bookname);
    strcpy(book.publisher, publisher);
    strcpy(book.publishTime, publishTime);
    book.categoryId = categoryId;
    return book;
}

void saveFile() {
    FILE *f;
    char path[100];
    printf("请输入保存的路径:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ID\t名称\t作者\t分类号\t出版社\t出版时间");
    for (i = 0; i < size; i++) {
        fprintf(f, "%c", '\n');
        fprintf(f, "%d\t", books[i].bookid);
        fprintf(f, "%s\t", books[i].bookname);
        fprintf(f, "%s\t", books[i].author);
        fprintf(f, "%d\t", books[i].categoryId);
        fprintf(f, "%s\t", books[i].publisher);
        fprintf(f, "%s\t", books[i].publishTime);
    }
    fclose(f);
    printf("已经保存成功");
}

void init() {
    addBook(createBook(1, "西游记", "吴承恩", "北京大学出版社", "1998-02-03", 2));
    addBook(createBook(2, "三国演义", "吴承恩", "清华大圩出版社", "1999-02-03", 2));
    addBook(createBook(3, "水浒传", "吴承恩", "南开大学出版社", "2000-02-03", 2));
    addBook(createBook(4, "红楼梦", "吴承恩", "天津大学出版社", "2001-02-03", 2));
}

int main() {

    init();

    while (1) {
        printf("\n");
        printf("1.增加图书\n");
        printf("2.删除图书\n");
        printf("3.修改图书\n");
        printf("4.查询图书\n");
        printf("5.所有图书\n");
        printf("6.保存到文件\n");
        printf("0.退出系统\n");
        int menuIndex;
        int id;
        printf("请输入:");
        scanf("%d", &menuIndex);
        switch (menuIndex) {
            case 1:
                Book book;
                printf("请输入id:");
                scanf("%d", &book.bookid);
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
                addBook(book);
                break;
            case 2:
                printf("请输入书的ID:");
                scanf("%d", &id);
                deleteBookById(id);
                break;
            case 3:
                updateBook();
                break;
            case 4:
                printf("请输入书的ID:");
                scanf("%d", &id);
                findBookById(id);
                break;
            case 5:
                printListInfo();
                break;
            case 6:
                saveFile();
                break;
            case 0:
                printf("感谢使用，程序退出");
                exit(0);
                break;
        }
    }


    return 0;
}
