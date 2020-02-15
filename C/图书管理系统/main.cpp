#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    // ͼ��id
    int bookid;
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
} Book;

Book books[100];
int size = 0;

void addBook(Book book) {
    books[size++] = book;
}


// ��ӡͼ����Ϣ
void printBookInfo(Book book) {
    printf("id:%d,����:%d,����%s,�����:%d,������:%s,����ʱ��:%s\n", book.bookid, book.bookname, book.author, book.categoryId,
           book.publisher, book.publishTime);
}

void findBookById(int id) {
    for (int i = 0; i < size; ++i) {
        if (id == books[i].bookid) {
            printBookInfo(books[i]);
            return;
        }
    }
    printf("û���ҵ�����Ҫ�����");
}

void updateBook() {
    printf("������Ҫ�޸ĵ����ID:");
    int id;
    scanf("%d", &id);
    for (int i = 0; i < size; ++i) {
        if (id == books[i].bookid) {
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

void deleteBookById(int id) {
    int index = -1;
    int i = 0;
    for (i = 0; i < size; ++i) {
        if (id == books[i].bookid) {
            index = i;
        }
    }

    if (index == -1) {
        printf("û���ҵ�IDΪ%d����", id);
    } else {
        for (i = index; i < size - 1; i++) {
            books[i] = books[i + 1];
        }
        size--;
        printf("ɾ���ɹ�");
    }

}

void printListInfo() {
    printf("һ����%d����\n", size);
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
    printf("�����뱣���·��:");
    scanf("%s", &path);
    f = fopen(path, "w");
    int i;
    fprintf(f, "ID\t����\t����\t�����\t������\t����ʱ��");
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
    printf("�Ѿ�����ɹ�");
}

void init() {
    addBook(createBook(1, "���μ�", "��ж�", "������ѧ������", "1998-02-03", 2));
    addBook(createBook(2, "��������", "��ж�", "�廪���׳�����", "1999-02-03", 2));
    addBook(createBook(3, "ˮ䰴�", "��ж�", "�Ͽ���ѧ������", "2000-02-03", 2));
    addBook(createBook(4, "��¥��", "��ж�", "����ѧ������", "2001-02-03", 2));
}

int main() {

    init();

    while (1) {
        printf("\n");
        printf("1.����ͼ��\n");
        printf("2.ɾ��ͼ��\n");
        printf("3.�޸�ͼ��\n");
        printf("4.��ѯͼ��\n");
        printf("5.����ͼ��\n");
        printf("6.���浽�ļ�\n");
        printf("0.�˳�ϵͳ\n");
        int menuIndex;
        int id;
        printf("������:");
        scanf("%d", &menuIndex);
        switch (menuIndex) {
            case 1:
                Book book;
                printf("������id:");
                scanf("%d", &book.bookid);
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
                addBook(book);
                break;
            case 2:
                printf("���������ID:");
                scanf("%d", &id);
                deleteBookById(id);
                break;
            case 3:
                updateBook();
                break;
            case 4:
                printf("���������ID:");
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
                printf("��лʹ�ã������˳�");
                exit(0);
                break;
        }
    }


    return 0;
}
