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
long xuehao;//�����ѧ��
char name1[20];
int r[MAX]; 
int adress;//����Ԫ�ص�λ��
int score[N];//����ĸ��Ƴɼ�
int deletenums;//ɾ����Ԫ��;
//int deleteindex=-1;//ɾ��Ԫ�ص��±�
int del_num;//ɾ����ѧ��
int findnums;//���ҵ�ѧ��
//int findindex;//�±�
int create(Seqlist*L);//�����༶����ϵͳ
void output(Seqlist*L);//��ӡ�༶����ϵͳ
void getscore(Seqlist*L,int);//����Ҫ�����ͬѧ�ĳɼ�
void insert(Seqlist *L,int i,int score1[N]);//����ɼ�
void delindex(Seqlist *L,int deletenums);//ɾ��ĳ��Ԫ�صĳɼ�
void find(Seqlist*L,int findnums);//��ѯ
void save(Seqlist*L);//�����ļ�
void filePrint();//��ȡ�ļ�
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
    	printf("\n                                          * * * * ѧ���ɼ�����ϵͳ * * * *\n");
        printf("                                                   1.¼��ѧ���ɼ�\n");
        printf("                                                   2.ɾ��ѧ���ɼ�\n");
        printf("                                                   3.����ѧ���ɼ�\n");
        printf("                                                   4.��ѯѧ���ɼ�\n");
        printf("                                                   5.����ѧ���ɼ�\n");
        printf("                                                   6.���ѧ���ɼ�\n");
        printf("                                                   7.����ѧ���ɼ�\n");
        printf("                                                   8.��ȡѧ���ɼ�\n");
        printf("                                                   0.�˳�����ϵͳ\n");
        printf("                                                  -1.�����Ļ\n");
        printf("                                         * * * * * * * * * * * * * * * * * * \n\n");
        printf("\n ������Ҫѡ��Ĺ��ܱ�ţ�");
        scanf("%d",&choose);
        while(getchar()!='\n');
        switch(choose)
        {
    	case 1:
		printf("\n1�������µ�����ϵͳ��\n\n");
        adress = create(L);
        break;//ѧ�����ݼ���¼��
        
        case 2: 
        printf("\n********************��ʼִ��ɾ��***********************\n");
        printf("������Ҫɾ����ѧ��:");
        scanf("%d",&del_num);//������Ҫɾ����ѧ�ţ�����0���˳�
        for(;del_num;)
        {
        	delindex(L,del_num);
	        scanf("%d",&del_num);
        }
        printf("\n********************ɾ���ɹ���*************************\n");
        output(L);
        break; //ѧ���ɼ�ɾ��
        
        case 3:
		getscore(L,adress);
        insert(L,adress,score); 
		break;//����ѧ������
		
        case 4: 
        printf("\n********************��ʼ��ѯ***********************\n");
        printf("������Ҫ��ѯ��ѧ��:");
        scanf("%d",&findnums);//������Ҫ��ѯ��ѧ�ţ�����0���˳�
        for(;findnums;)
        {
        	find(L,findnums);
		    //printf("������Ҫ��ѯ��ѧ��:");
		    scanf("%d",&findnums);
        }
		
		break;
		
        case 5:
        	printf("1.�ܷ����а�\n2.�������а�\n ");
			scanf("%d",&choose1);
			if(choose1==1)
			{
				printf("1.��С����\n2.�Ӵ�С\n");
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
				printf("1.��ԭ\n2.��ɢ\n3.΢��\n ");
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
						    printf("\n\n ������������!���������룺\n\n");
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
	    	printf("\n\n ������������!���������룺\n\n");
	    	break;
		}
    }
    return 0;
}

int create(Seqlist*L)
{
    printf("����������¼���������");
    scanf("%d",&(*L).last);
    for(i=0;i<L->last;i++)
    {
        printf("�������%dλͬѧ��ѧ�ţ�",i+1);
        scanf("%d",&(*L).xh[i]);
		while(getchar()!='\n');
		//getchar();
		printf("�������%dλͬѧ��������",i+1);
		gets((*L).name[i]);
        for(j=0;j<N;j++)
        {
        if(j==0)
			{
			printf("������ѧ��Ϊ%dͬѧ����ԭ�ɼ�:",L->xh[i]);
			//getchar();
			scanf("%d",&(*L).Num[i][j]);
			}
			else if(j==1)
			{
				printf("������ѧ��Ϊ%dͬѧ����ɢ�ɼ�:",L->xh[i]);
				//getchar();
				scanf("%d",&(*L).Num[i][j]);
			}
			else
			{
				printf("������ѧ��Ϊ%dͬѧ��΢���ɼ�:",L->xh[i]);
				//getchar();
				scanf("%d",&(*L).Num[i][j]);
			}
        }
		(*L).sum[i]=(*L).Num[i][j-1]+(*L).Num[i][j-2]+(*L).Num[i][j-3];
    }
	return 0;
}

void output(Seqlist*L)//��ӡ����
{
    for(i=0;i<L->last;i++)
    {
         switch(i)
        {
        case 0:
            printf("ѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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

void getscore(Seqlist *L, int adress)                                              //����   address�ǲ���Ԫ�ص�λ�� 
{
	adress=L->last+1; 
    printf("\n");
    printf("������Ҫ����ͬѧ��ѧ�ţ�");       //����ѧ�� 
    scanf("%d",&xuehao);
	while(getchar()!='\n');
	printf("������Ҫ�����������");           //�������� 
	scanf("%s",name1);
    for(i=0;i<N;i++)
    {
        if(i==0)
        {
			printf("������ѧ��Ϊ%dͬѧ����ԭ�ɼ�:",xuehao);          //����ɼ� 
			scanf("%d",&score[i]);
		}
		else if(i==1)
		{
			printf("������ѧ��Ϊ%dͬѧ����ɢ�ɼ�:",xuehao);
			scanf("%d",&score[i]);
		}
		else
		{
			printf("������ѧ��Ϊ%dͬѧ��΢���ɼ�:",xuehao);
			scanf("%d",&score[i]);
		}
		(*L).sum[adress-1]=score[0]+score[1]+score[2];
    }
}

void  insert(Seqlist *L,int i,int score1[N])
{
	L->last++;   
	int k;                   //���ȼ� 1 
	i=L->last;                      //�ѱ�L�����һ�� ���ݸ��� i 
	L->xh[i-1]=xuehao;              //������ѧ����ѧ�� �ݸ� ��L ���һ�����ݵ� ѧ��Ԫ�� 
	strcpy(L->name[i-1], name1);    //�ַ���  ������ѧ�������� �ݸ� ��L ���һ�����ݵ� ����Ԫ�� 
	for(k=0;k<3;k++)
    {
    	L->Num[i-1][k]=score1[k];   //������ѧ���ĳɼ� �ݸ� ��L ���һ�����ݵ� �ɼ�Ԫ�� 
    }
}

void delindex(Seqlist *L,int deletenums)//ɾ��
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
	   	printf("\n ��ɾ��ѧ��Ϊ%d�ĳɼ�\n����ɾ���밴ѧ�ţ�����ɾ�������� 0 �˳�\n",deletenums);
	   L->last--;
	}
	else
	{
		printf("���޴���\n");
	}
}

void save(Seqlist*L)//����
{
    FILE *f;
    char path[100];
    printf("�����뱣���·��:");
    scanf("%s",&path);
    f=fopen(path,"w");
    for(i=0;i<L->last;i++)
    {
		 switch(i)
		 {
			case 0:
				fprintf(f,"ѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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
    printf("�Ѿ�����ɹ�");
}

void filePrint()//��ȡ
{
    FILE *f;
    char path[100];
    char text[1024];
    printf("�������ȡ��·��:");
    scanf("%s",&path);
    f=fopen(path,"r");
    while (fgets(text,1024,f)!=NULL)
    {
        puts(text);
    }
    fclose(f);
}

void find(Seqlist *L,int findnums)//��ѯ
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
		printf("ѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
        printf("\n");
        printf("%d\t",L->xh[i]);
        printf("%s\t",(*L).name[i]);
        for(j=0;j<N;j++)
        {
            printf("%d",L->Num[findindex][j]);
            printf("\t");
        }
        printf("%d",(*L).sum[i]);
		printf("\n ���ҵ�ѧ��Ϊ%d�ĳɼ���\n������ѯ������ѧ�ţ����������� 0 �˳�\n",findnums);
		//scanf("%d",&findnums);
    }	
	else
	{
		printf("���޴��ˡ�\n���������Ҫ��ѯ��ѧ�ţ�����������0�˳�\n");
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
                printf("\nѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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
    printf("\nѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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
    printf("\nѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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
    printf("\nѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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
    printf("\nѧ��\t����\t��ԭ\t��ɢ\t΢��\t�ܷ�");
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
