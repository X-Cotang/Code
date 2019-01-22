/*#include<stdio.h>
#include<conio.h>
void main(){
int n;
scanf("%d",&n);
int *a=(int *)calloc(n,sizeof(int));
for (int i=0;i<=n;i++){
    scanf("%d",&a[i]);
}
int m;
scanf("%d",&m);
int *b=(int *)calloc(m,sizeof(int));
for (int i=0;i<=m;i++){
    scanf("%d",&b[i]);
}
int *c,s;
if(n>m){c=(int*)calloc(n,sizeof(int));
for(int i=0;i<=n;i++){
    c[i]+=a[i];
    if(i<=m){c[i]+=b[i];}
}  }
else{c=(int *)calloc(m,sizeof(int);
for(int i=0;i<=m;i++){
    c[i]+=b[i];
    if(i<=n){c[i]+=a[i];}
}
}

}
*/
#include<stdio.h>
#include<conio.h>
void main(){
printf("%d",sizeof(int));
printf("%d",sizeof(char));
}
