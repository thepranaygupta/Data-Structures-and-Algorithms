#include<stdio.h>
#include<stdlib.h>
void print(int arr[],int n)
{
	printf("Array: ");
	for(int k=0;k<n;++k)
		printf("%d ",arr[k]);
	printf("\n");
}
int binary_search(int arr[],int target,int n)
{
	for(int i=0,j=n-1;i<=j;)
	{
		int m=i+(j-i)/2;
		if(arr[m]==target) return m;
		else if(arr[m]>target) j=m-1;
		else i=m+1;
	}
	return -1;
}
int main()
{
	int n;
	printf("Enter n: ");
	scanf("%d",&n);
	printf("Enter elements of array in ascending order.\n");
	int *arr=(int*)malloc(n*sizeof(int));
	for(int k=0;k<n;++k)
	{
		printf("Enter element %d: ");
		scanf("%d",arr+k);
	}
	
	
	int target;
	printf("Enter the target element to search: ");
	scanf("%d",&target);
	print(arr,n);
	int pos=binary_search(arr,target,n);
	if(pos==-1)
	{
		printf("Target element %d is not found in the array.\n",target,pos);
	}
	else printf("Target element %d is found at the index location %d.\n",target,pos);
	return 0;
}


/* Sample input
Enter n: 5
Enter elements of array in ascending order.
Enter element 20: 1
Enter element 1: 2
Enter element 2: 3
Enter element 3: 4
Enter element 4: 5
Enter the target element to search: 545
Array: 1 2 3 4 5 
Target element 545 is not found in the array.


Enter n: 5
Enter elements of array in ascending order.
Enter element 20: 1
Enter element 1: 2
Enter element 2: 3
Enter element 3: 4
Enter element 4: 5
Enter the target element to search: 2
Array: 1 2 3 4 5 
Target element 2 is found at the index location 1.

*/

