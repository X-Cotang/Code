#include"stdio.h"
#include"conio.h"
typedef struct {
    float thuc;
    float ao;
}sp;
void cong(sp sp1,sp sp2){
    sp kq;
    kq.thuc=sp1.thuc+sp2.thuc;
    kq.ao=sp1.ao+sp2.ao;
    printf("%f+%fi",kq.thuc,kq.ao);
}
void nhan(sp sp1,sp sp2){
    sp kq;
    kq.thuc=sp1.thuc*sp2.thuc-sp1.ao*sp2.ao;
    kq.ao=sp1.thuc*sp2.ao+sp2.thuc*sp1.ao;
    printf("%f+%fi",kq.thuc,kq.ao);
}
void main(){
    sp sp1,sp2;
    scanf("%f%f",&sp1.thuc,&sp2.ao);
}
