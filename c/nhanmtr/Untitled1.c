/*#include<stdio.h>
#include<conio.h>
void main(){
int n,m,h;
label:scanf("%d%d%d",&n,&m,&h);
if(n!=h){goto label;}
float **a;
a=(float *)calloc(n,sizeof(float));
float **b;
b=(float *)calloc(m,sizeof(float));
for(int i=0;i<n;i++){
a[i]=(float *)calloc(m,sizeof(float));}
for(int i=0;i<n;i++){
	for(int j=0;j<m;j++){
    scanf("%f",&a[i][j]);
	}
}
for(int i=0;i<m;i++){
b[i]=(float *)calloc(h,sizeof(float));}
for(int i=0;i<m;i++){
	for(int j=0;j<h;j++){
    scanf("%f",&b[i][j]);
	}
}

float **c;
c=(float *)calloc(n,sizeof(float));
for(int i=0;i<n;i++){
	c[i]=(float *) calloc(h,sizeof(float));
}
for(int i=0;i<n;i++){
	for(int j=0;j<h;j++){
	for(int l=0;l<m;l++){
		c[i][j]+=a[i][l]*b[l][j];
	}
	}
}
for(int i=0;i<n;i++){
	for(int j=0;j<h;j++){printf("%f\t",c[i][j]);}
	printf("\n");
}
}
*/
#include<stdio.h>
#include<conio.h>
int *a,*b,*d;
void nhap(int n,int c,int m){

    a=calloc(n*c,sizeof(int));
    b=calloc(c*m,sizeof(int));
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<c;j++){
            printf("Nhap vao phan tu A[%d][%d]",i,j);
            scanf("%d",(a+i*n+j));
        }
    }
    for(i=0;i<c;i++){
        for(j=0;j<m;j++){
            printf("Nhap vao phan tu B[%d][%d]",i,j);
            scanf("%d",(b+i*n+j));
        }
    }
}
void nhan(int n,int c,int m){
    d=calloc(n*m,sizeof(int));
    int i,j,l;
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            for(l=0;l<c;l++){
                *(d+i*n+j)+=(*(a+i*n+l))*(*(b+l*m+j));
            }
        }
    }
}
//void in(int n,int c,int m){

void main(){
    int n,c,m;
    printf("Nhap vao so hang so cot cua A,so cot cua B");
    scanf("%d%d%d",&n,&c,&m);
    nhap(n,c,m);
    nhan(n,c,m);
//    in(n,c,m);
}




/*#include<stdio.h>
#include<conio.h>
void tinh(int *a){

}
void main(){
int *a=malloc(sizeof(int));
int b=2;
int *c;
c=&b;
*a=*c;

}
*/
