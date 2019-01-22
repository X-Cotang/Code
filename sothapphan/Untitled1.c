#include<stdio.h>
#include<conio.h>

typedef struct sothapphan{
int tu;
int mau;
}sotp;

void nhapdsps(int n,sotp *tp){
int i;
for(i=0;i<n;i++){
    scanf("%d",&tp[i].tu);
    scanf("%d",&tp[i].mau);
}
}
void rutgon(int n,sotp *tp){
int i;
for(i=0;i<n;i++){
    int a=tp[i].tu,b=tp[i].mau;
    int p=a*b;
    while(a!=b){
        if(a>b){a=a-b;}else{b=b-a;}
    }
    tp[i].tu=tp[i].tu/a;
    tp[i].mau=tp[i].mau/a;
}
}

void main(){
int n,i;
float a;
scanf("%d",&n);
sotp *tp;
tp=(sotp *)calloc(n,sizeof(sotp));
nhapdsps(n,tp);
rutgon(n,tp);
//sosanh();
}


