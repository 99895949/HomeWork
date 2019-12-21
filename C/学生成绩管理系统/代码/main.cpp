#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#define MAX 100
#define N 3
typedef struct
{
    long xh[MAX];
    int Num[MAX][N];
	int sum[MAX];
	char name[MAX][MAX];
    int last;
	char fin[MAX];
}Seqlist;
int i,j,y;
long xuehao;//插入的学号
char name1[20];
int r[MAX]; 
int adress;//插入元素的位置
int score[N];//插入的各科成绩
int deletenums;//删除的元素;
//int deleteindex=-1;//删除元素的下标
int del_num;//删除的学号
int findnums;//查找的学号
//int findindex;//下标
int create(Seqlist*L);//创建班级管理系统
void output(Seqlist*L);//打印班级管理系统
void getscore(Seqlist*L,int);//输入要插入的同学的成绩
void insert(Seqlist *L,int i,int score1[N]);//插入成绩
void delindex(Seqlist *L,int deletenums);//删除某个元素的成绩
void find(Seqlist*L,int findnums);//查询
void save(Seqlist*L);//保存文件
void filePrint();//读取文件
void minmax(Seqlist*L);
void maxmin(Seqlist*L);
void mayuan(Seqlist*L);
void lisan(Seqlist*L);
void weiji(Seqlist*L);
int main()
{
    Seqlist*L,l;
    L=&l;
    int choose,choose1,choose2,choose3;
    for(;;)
    {
    	printf("\n                                          * * * * 学生成绩管理系统 * * * *\n");
        printf("                                                   1.录入学生成绩\n");
        printf("                                                   2.删除学生成绩\n");
        printf("                                                   3.插入学生成绩\n");
        printf("                                                   4.查询学生成绩\n");
        printf("                                                   5.排序学生成绩\n");
        printf("                                                   6.输出学生成绩\n");
        printf("                                                   7.保存学生成绩\n");
        printf("                                                   8.读取学生成绩\n");
        printf("                                                   0.退出管理系统\n");
        printf("                                                  -1.清除屏幕\n");
        printf("                                         * * * * * * * * * * * * * * * * * * \n\n");
        printf("\n 请输入要选择的功能编号：");
        scanf("%d",&choose);
        while(getchar()!='\n');
        switch(choose)
        {
    	case 1:
		printf("\n1、建立新的数据系统。\n\n");
        adress = create(L);
        break;//学生数据键盘录入
        
        case 2: 
        printf("\n********************开始执行删除***********************\n");
        printf("请输入要删除的学号:");
        scanf("%d",&del_num);//请输入要删除的学号，输入0则退出
        for(;del_num;)
        {
        	delindex(L,del_num);
	        scanf("%d",&del_num);
        }
        printf("\n********************删除成功后*************************\n");
        output(L);
        break; //学生成绩删除
        
        case 3:
		getscore(L,adress);
        insert(L,adress,score); 
		break;//插入学生数据
		
        case 4: 
        printf("\n********************开始查询***********************\n");
        printf("请输入要查询的学号:");
        scanf("%d",&findnums);//请输入要查询的学号，输入0则退出
        for(;findnums;)
        {
        	find(L,findnums);
		    //printf("请输入要查询的学号:");
		    scanf("%d",&findnums);
        }
		
		break;
		
        case 5:
        	printf("1.总分排行榜\n2.单科排行榜\n ");
			scanf("%d",&choose1);
			if(choose1==1)
			{
				printf("1.从小到大\n2.从大到小\n");
				scanf("%d",&choose2);
				switch(choose2)
					{
						case 1:
							minmax(L);
							break;
						case 2:
							maxmin(L);
							break;
					}
			}
			else if(choose1==2)
			{
				printf("1.马原\n2.离散\n3.微机\n ");
				scanf("%d",&choose3);
					switch(choose3)
					{
						case 1:
							mayuan(L);
							break;
						case 2:
							lisan(L);
							break;
						case 3:
							weiji(L);
							break;
						default: 
						    printf("\n\n 您的输入有误!请重新输入：\n\n");
		                    break;
					}
			}
		    break;
		
        case 6:
		    output(L); 
            break; 
        
		case 7:
			save(L);
	    	break;
		
		case 8:
			filePrint();
	    	break;
		
        case 0:
		    exit(0);
	     	break;
	 	
        case -1:
	    	system("cls");
	    	break;
		
        default: 
	    	printf("\n\n 您的输入有误!请重新输入：\n\n");
	    	break;
		}
    }
    return 0;
}

int create(Seqlist*L)
{
    printf("请输入所需录入的人数：");
    scanf("%d",&(*L).last);
    for(i=0;i<L->last;i++)
    {
        printf("请输入第%d位同学的学号：",i+1);
        scanf("%d",&(*L).xh[i]);
		while(getchar()!='\n');
		//getchar();
		printf("请输入第%d位同学的姓名：",i+1);
		gets((*L).name[i]);
        for(j=0;j<N;j++)
        {
        if(j==0)
			{
			printf("请输入学号为%d同学的马原成绩:",L->xh[i]);
			//getchar();
			scanf("%d",&(*L).Num[i][j]);
			}
			else if(j==1)
			{
				printf("请输入学号为%d同学的离散成绩:",L->xh[i]);
				//getchar();
				scanf("%d",&(*L).Num[i][j]);
			}
			else
			{
				printf("请输入学号为%d同学的微机成绩:",L->xh[i]);
				//getchar();
				scanf("%d",&(*L).Num[i][j]);
			}
        }
		(*L).sum[i]=(*L).Num[i][j-1]+(*L).Num[i][j-2]+(*L).Num[i][j-3];
    }
	return 0;
}

void output(Seqlist*L)//打印报告
{
    for(i=0;i<L->last;i++)
    {
         switch(i)
        {
        case 0:
            printf("学号\t姓名\t马原\t离散\t微机\t总分");
        }
        printf("\n");
        printf("%d\t",L->xh[i]);
		printf("%s\t",(*L).name[i]);
        for(j=0;j<N;j++)
        {
            printf("%d",L->Num[i][j]);
			printf("\t");
        }
		printf("%d",(*L).sum[i]);	
    }
}

void getscore(Seqlist *L, int adress)                                              //插入   address是插入元素的位置 
{
	adress=L->last+1; 
    printf("\n");
    printf("请输入要插入同学的学号：");       //存入学号 
    scanf("%d",&xuehao);
	while(getchar()!='\n');
	printf("请输入要插入的姓名：");           //存入姓名 
	scanf("%s",name1);
    for(i=0;i<N;i++)
    {
        if(i==0)
        {
			printf("请输入学号为%d同学的马原成绩:",xuehao);          //存入成绩 
			scanf("%d",&score[i]);
		}
		else if(i==1)
		{
			printf("请输入学号为%d同学的离散成绩:",xuehao);
			scanf("%d",&score[i]);
		}
		else
		{
			printf("请输入学号为%d同学的微机成绩:",xuehao);
			scanf("%d",&score[i]);
		}
		(*L).sum[adress-1]=score[0]+score[1]+score[2];
    }
}

void  insert(Seqlist *L,int i,int score1[N])
{
	L->last++;   
	int k;                   //表长度加 1 
	i=L->last;                      //把表L的最后一个 数据赋给 i 
	L->xh[i-1]=xuehao;              //把输入学生的学号 递给 表L 最后一个数据的 学号元素 
	strcpy(L->name[i-1], name1);    //字符串  把输入学生的姓名 递给 表L 最后一个数据的 姓名元素 
	for(k=0;k<3;k++)
    {
    	L->Num[i-1][k]=score1[k];   //把输入学生的成绩 递给 表L 最后一个数据的 成绩元素 
    }
}

void delindex(Seqlist *L,int deletenums)//删除
{
    int deleteindex=-1;
	for(i=0;i<L->last;i++)
	{
		if(deletenums==L->xh[i])
		{
			deleteindex=i;
			break;
		}
	}
	if(deleteindex!=-1)
	{
	   for(i=deleteindex;i<L->last-1;i++)
	   {
	       L->xh[i]=L->xh[i+1];
	       for(j=0;j<N;j++)
	       {
	           L->Num[i][j]=L->Num[i][j+1];
	       }


	   }
	   	printf("\n 已删除学号为%d的成绩\n继续删除请按学号，不需删除则输入 0 退出\n",deletenums);
	   L->last--;
	}
	else
	{
		printf("查无此人\n");
	}
}

void save(Seqlist*L)//保存
{
    FILE *f;
    char path[100];
    printf("请输入保存的路径:");
    scanf("%s",&path);
    f=fopen(path,"w");
    for(i=0;i<L->last;i++)
    {
		 switch(i)
		 {
			case 0:
				fprintf(f,"学号\t姓名\t马原\t离散\t微机\t总分");
		 }
        fprintf(f,"%c",'\n');
        fprintf(f,"%d\t",L->xh[i]);
		fprintf(f,"%s\t",(*L).name[i]);
        for(j=0;j<N;j++)
        {
            fprintf(f,"%d",L->Num[i][j]);
			fprintf(f,"%c",'\t');
        }
		fprintf(f,"%d",(*L).sum[i]);	
    }
    fclose(f);
    printf("已经保存成功");
}

void filePrint()//读取
{
    FILE *f;
    char path[100];
    char text[1024];
    printf("请输入读取的路径:");
    scanf("%s",&path);
    f=fopen(path,"r");
    while (fgets(text,1024,f)!=NULL)
    {
        puts(text);
    }
    fclose(f);
}

void find(Seqlist *L,int findnums)//查询
{
	int findindex = -1;
	for(i=0;i<L->last;i++)
	{
		if(findnums==L->xh[i])
		{
			findindex=i;
			break;
		}
	}
	if(findindex!=-1)
	{
		printf("学号\t姓名\t马原\t离散\t微机\t总分");
        printf("\n");
        printf("%d\t",L->xh[i]);
        printf("%s\t",(*L).name[i]);
        for(j=0;j<N;j++)
        {
            printf("%d",L->Num[findindex][j]);
            printf("\t");
        }
        printf("%d",(*L).sum[i]);
		printf("\n 已找到学号为%d的成绩，\n继续查询请输入学号，不需则输入 0 退出\n",findnums);
		//scanf("%d",&findnums);
    }	
	else
	{
		printf("查无此人。\n请继续输入要查询的学号，不需则输入0退出\n");
	}
}

 int QKPass(int r[],int low,int high) 
{
	
	int x;
	x=r[low];
	while(low<high)
	{
		while(low<high&&r[high]>=x )  high--;
		if(low<high)   {r[low]=r[high];   low++;}
		while(low<high&&r[low] <x )    low++;
		if(low<high)   {r[high]=r[low];   high--;}
	}
	r[low]=x;      
	return low; 
}

void QKSort(int r[],int low,int high) 
{
	if(low<high)
	{
		int pos;
		pos=QKPass(r,low,high);
		QKSort(r,low,pos-1);
		QKSort(r,pos+1,high);
	}
}

void minmax(Seqlist*L)
{
	for(i=1;i<=L->last;i++)
    {
		r[i]=(*L).sum[i-1];
    }
    QKSort(r,1,L->last);
    int m,n;
    for(i=1;i<=L->last;i++)
    {
    	switch(i)
            {
            case 1:
                printf("\n学号\t姓名\t马原\t离散\t微机\t总分");
            }
        printf("\n");
        for(m=0;m<L->last;m++)	
        {
        	if(r[i]==(*L).sum[m])
        	{
        		//printf("%d",m);
			    printf("%d\t",L->xh[m]);
		     	printf("%s\t",(*L).name[m]);
                for(j=0;j<N;j++)
                {
                	printf("%d",L->Num[m][j]);
		    		printf("\t");
                }
	     	}
        }
    	printf("%4d\t",r[i]);
    }
}

void maxmin(Seqlist*L)
{
	for(i=1;i<=L->last;i++)
    {
		r[i]=(*L).sum[i-1];
    }
    QKSort(r,1,L->last);
    int m,n;
    printf("\n学号\t姓名\t马原\t离散\t微机\t总分");
    for(i=L->last;i>=1;i--)
    {
        printf("\n");
        for(m=0;m<L->last;m++)	
        {
        	if(r[i]==(*L).sum[m])
        	{
        		//printf("%d",m);
			    printf("%d\t",L->xh[m]);
		     	printf("%s\t",(*L).name[m]);
                for(j=0;j<N;j++)
                {
                	printf("%d",L->Num[m][j]);
		    		printf("\t");
                }
	     	}
        }
    	printf("%4d",r[i]);
    }
    
}
void mayuan(Seqlist*L)
{
	for(i=1;i<=L->last;i++)
    {
		r[i]=L->Num[i-1][0];
    }
    QKSort(r,1,L->last);
    int m,n;
    printf("\n学号\t姓名\t马原\t离散\t微机\t总分");
    for(i=L->last;i>=1;i--)
    {
        printf("\n");
        for(m=L->last;m>=0;m--)	
        {
        	if(r[i]==L->Num[m][0])
        	{
        		//printf("%d",m);
			    printf("%d\t",L->xh[m]);
		     	printf("%s\t",(*L).name[m]);
                for(j=0;j<N;j++)
                {
                	printf("%d",L->Num[m][j]);
		    		printf("\t");
                }    	
				printf("%d",(*L).sum[m]);
	     	}
        }

    }
}

void lisan(Seqlist*L)
{
	for(i=1;i<=L->last;i++)
    {
		r[i]=L->Num[i-1][1];
    }
    QKSort(r,1,L->last);
    int m,n;
    printf("\n学号\t姓名\t马原\t离散\t微机\t总分");
    for(i=L->last;i>=1;i--)
    {
        printf("\n");
        for(m=L->last;m>=0;m--)	
        {
        	if(r[i]==L->Num[m][1])
        	{
        		//printf("%d",m);
			    printf("%d\t",L->xh[m]);
		     	printf("%s\t",(*L).name[m]);
                for(j=0;j<N;j++)
                {
                	printf("%d",L->Num[m][j]);
		    		printf("\t");
                }    	
				printf("%d",(*L).sum[m]);
	     	}
        }

    }
}
void weiji(Seqlist*L)
{
	for(i=1;i<=L->last;i++)
    {
		r[i]=L->Num[i-1][2];
    }
    QKSort(r,1,L->last);
    int m,n;
    printf("\n学号\t姓名\t马原\t离散\t微机\t总分");
    for(i=L->last;i>=1;i--)
    {
        printf("\n");
        for(m=L->last;m>=0;m--)	
        {
        	if(r[i]==L->Num[m][2])
        	{
        		//printf("%d",m);
			    printf("%d\t",L->xh[m]);
		     	printf("%s\t",(*L).name[m]);
                for(j=0;j<N;j++)
                {
                	printf("%d",L->Num[m][j]);
		    		printf("\t");
                }    	
				printf("%d",(*L).sum[m]);
	     	}
        }
    }
}
