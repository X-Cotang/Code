#include<conio.h>
#include<math.h>
typedef struct StructSoPhuc
{
	float thuc;
	float ao;
};
typedef struct StructSoPhuc SOPHUC;
void nhapDSSP(int n,SOPHUC *sop){
int i;
for(i=0;i<n;i++){
        printf("Nhap vao phan thuc va ao so phuc thu %d\n",i+1);
        scanf("%f%f",&sop[i].thuc,&sop[i].ao);
    }
}
void nhapSP(SOPHUC *sp){
//sp=(SOPHUC *)malloc(sizeof(SOPHUC));
printf("nhap vao phan thuc so phuc : ");
scanf("%f",&sp->thuc);
printf("nhap vao phan ao so phuc : ");
scanf("%f",&sp->ao);
}
SOPHUC tong(SOPHUC sp1,SOPHUC sp2){
SOPHUC tog;
tog.thuc=sp1.thuc+sp2.thuc;
tog.ao=sp1.ao+sp2.ao;
return tog;
}
SOPHUC tich(SOPHUC sp1,SOPHUC sp2){
SOPHUC tih;
tih.ao=sp1.thuc*sp2.ao+sp2.thuc*sp1.ao;
tih.thuc=sp1.thuc*sp2.thuc-sp1.ao*sp2.ao;
return tih;
}

void main(){
    int n,i;
    SOPHUC *sop,tst,*sp,tog,tih;
    printf("Nhap vao so so phuc: ");
    scanf("%d",&n);
    sop=(SOPHUC *) calloc(n,sizeof(SOPHUC));
    nhapDSSP(n,sop);
    tog.thuc=tog.ao=0;
    for(i=0;i<n;i++){
        tog=tong(tog,sop[i]);
    }
    printf("tong cua tat ca so phuc  la: %f+ %f i\n",tog.thuc,tog.ao);

    for(i=0;i<n-1;i++){
        if(i==0){tih.thuc=sop[0].thuc;tih.ao=sop[0].ao;}
        tih=tich(tih,sop[i+1]);
        //printf("tich cua hai so phuc %d va %d la: %f+ %f i\n",i+1,i+2,tih.thuc,tih.ao);
    }
    printf("tich cua tat ca so phuc la: %f+ %f i\n",tih.thuc,tih.ao);

}
