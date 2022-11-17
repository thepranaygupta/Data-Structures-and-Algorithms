#include <stdio.h>

int fac (int n){
    int f = 1;
    for (int i = 1; i <= n; i++){
        f *= i;
    }
    return f;
}

int fun(int n,int r){
    int b = n-r;
    return fac(n)/(fac(b)*fac(r));
}

int main() {
	int n;
    printf("Enter number of rows:");
    scanf("%d",&n);
    printf("Pascal's triangle:\n");
    for (int i = -1; i < n; i++){
        for (int j = n-i; j >= 0; j--){
            printf(" ");
        }
        for (int j = 0; j <= i+1; j++){
            printf("%d ",fun(i+1,j));
        }
        printf("\n");
    }return 0;
}
