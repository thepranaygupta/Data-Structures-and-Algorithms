#include <stdio.h>
#include <stdlib.h>

int temp[20],arr[20];
int m,k,i,l;
void partition(int l,int h);
void merge(int low, int mid, int high);
void main(){
    int n;
    printf("Enter number of elements of the array:\n");
    scanf("%d",&n);
    printf("Enter the %d element of the array:\n", n);
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }

    partition(0,(n-1));
    printf("The sorted array is:\n");
    for(i=0;i<n;i++)
        printf("%d ",arr[i]);
}
void partition(int l1,int h1)
{
    int m1;
    if(l1<h1)
    {
        m1=(l1+h1)/2;
        partition(l1,m1);
        partition((m1+1),h1);
        merge(l1,m1,h1);
    }
}
void merge(int low, int mid, int high)
{
    l= low;
    i= low;
    m= mid+1;
    while(l<=mid && m<=high)
    {
        if(arr[l]<=arr[m])
        {
            temp[i]=arr[l];
            l=l+1;
        }
        else{
            temp[i]=arr[m];
            m=m+1;
        }
        i=i+1;
    }
    if(l>mid)
    {
        for(k=m;k<=high;k++)
        {
            temp[i]=arr[k];
            i=i+1;
        }
    }
    else {
        for(k=l;k<=mid;k++)
        {
            temp[i]=arr[k];
            i=i+1;
        }

    }
    for(k=low;k<=high;k++)
        arr[k]=temp[k];
}