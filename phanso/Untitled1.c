#include<stdio.h>
#include<conio.h>
typedef struct phanso{
    int tu;
    int mau;
}ps;
void nhapd(int n,ps *pso){
    for(int i=0;i<n;i++){
    scanf("%d",&pso[i].tu);
    scanf("%d",&pso[i].mau);}
}
ps rutgon(ps pso){
    int a=pso.tu;
    int b=pso.mau;
    while(a!=b){if(a>b){a=a-b;}else{b=b-a;}}
    pso.tu=pso.tu/a;
    pso.mau=pso.mau/a;
return pso;
}
void cong(ps phso1,ps phso2){
    ps kq;
    if(phso1.mau==phso2.mau){
            kq.tu=phso1.tu+phso2.tu;
            kq.mau=phso1.mau;
            kq=rutgon(kq);}
    else{
    kq.mau=phso1.mau*phso2.mau;
    kq.tu=phso1.tu*phso2.mau+phso2.tu*phso1.mau;
    kq=rutgon(kq);
    }
    printf("%d\\%d\n",kq.tu,kq.mau);
}
void nhan(ps phso1,ps phso2){
    ps kq;
    kq.tu=phso1.tu*phso2.tu;
    kq.mau=phso1.mau*phso2.mau;
    kq=rutgon(kq);
    printf("%d\\%d\n",kq.tu,kq.mau);
}
void chia(ps phso1,ps phso2){
    ps kq;
    kq.tu=phso1.tu*phso2.mau;
    kq.mau=phso1.mau*phso2.tu;
    kq=rutgon(kq);
    printf("%d\\%d\n",kq.tu,kq.mau);
}
void main(){
    int n;
    scanf("%d",&n);
    ps *pso,phso1,phso2,kq;
    pso=(ps *)calloc(n,sizeof(ps));
    nhapd(n,pso);
    for(int i=0;i<n;i++){
        pso[i]=rutgon(pso[i]);
    }
    scanf("%d",&phso1.tu);
    scanf("%d",&phso1.mau);
    scanf("%d",&phso2.tu);
    scanf("%d",&phso2.mau);
    cong(phso1,phso2);
    nhan(phso1,phso2);
    chia(phso1,phso2);
}
