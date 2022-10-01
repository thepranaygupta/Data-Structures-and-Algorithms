//program to implement binary search using function//
#include <stdio.h>
void BinarySearch(int a[],int n,int e){
    int high , low=0 ,mid;
    low = 0;
    high = n - 1;
    mid = (low+high)/2;
    while (low <= high) {
        if(a[mid] < e)
        low = mid + 1;
        else if (a[mid] == e) {
            printf("%d found at %d position. \n", e, mid+1);
            break;
            }
            else
            high = mid - 1;
            mid = (low + high)/2;
    }
            if(low > high)
            printf("Not found! %d isn't present in the list\n", e);
                        }
            


int read(int a[],int n)
{
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    return 0;
}

int main()
{
    int a[10],n,e;
    printf("Enter the limit: ");
    scanf("%d",&n);
    read(a,n);
    printf("Enter the element to be searched :");
    scanf("%d",&e);
    BinarySearch(a,n,e);
    return 0;

}
	
/*COMPILATION STEP
gcc 03_BinarySearch.c -o 03_BinarySearch
EXECUTION STEP
./03_BinarySearch 
output 
Enter the limit: 6
1
2
3
4
5
6
Enter the element to be searched :3
3 found at 3 position. */