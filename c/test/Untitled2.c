/*#include<stdio.h>
#include<conio.h>
typedef struct{
    int a;
    char b[20];
}sv;
typedef union{
    int a;
    char b[200];
}he;
void main(){
    //char a[200];
    //int b=1000;
//printf("%d\n",sizeof(b));
printf("%d\n",sizeof(he));
for(int i=0;i<6;printf("%d\n",i++)){};
fprintf(stdout,"helodat &d");
}
*/
#include<stdio.h>
#include<conio.h>

main()
{
int i,j,k,l,n;

printf("Nhap pham vi: ");
scanf("%d",&n);
for(i=1;i<=n;i++){
    for(j=1;j<=n-i;j++){
    printf(" ");
    }
    for(k=1;k<=i;k++){
    printf("%d",k);
    }
    for(l=i-1;l>=1;l--){
    printf("%d",l);
    }
    printf("\n");
}

printf("\n\n===========================\n");
printf("VietJack chuc cac ban hoc tot!");
getch();
}
