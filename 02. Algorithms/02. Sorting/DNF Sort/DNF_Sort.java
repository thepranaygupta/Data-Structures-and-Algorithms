import java.io.*;   
class DNF {   
static void JTP(int arr[], int arr_size)   
{   
int low = 0;   
int high = arr_size - 1;   
int mid = 0, temp=0; // We use temporary variable for swapping   
while (mid <= high)   
{   
switch (arr[mid])   
{  
case 0: // Here mid pointer points is at 0.  
{   
temp = arr[low];   
arr[low] = arr[mid];   
arr[mid] = temp;   
low++;   
mid++;   
break;  
}   
case 1: // Here mid pointer points is at 1.  
mid++;   
break;   
case 2: // Here mid pointer points is at 2.  
{   
temp = arr[mid];   
arr[mid] = arr[high];   
arr[high] = temp;   
high--;   
break;   }   
}   }   }   
// Now we have to call function to print array arr[]   
static void printArray(int arr[], int arr_size)   
{   
int i;   
for (i = 0; i < arr_size; i++)   
System.out.print(arr[i]+" ");   
System.out.println("");   
}   
//Now we use driver function to check for above functions  
public static void main (String[] arguments)   
{   
int arr[] = {0, 1, 0, 1, 2, 0, 1, 2};   
int arr_size = arr.length;   
System.out.println("Array before executing the DNFS algorithm : ");   
printArray(arr, arr_size);   
JTP(arr, arr_size);   
System.out.println("\nArray after executing the DNFS algorithm : ");   
printArray(arr, arr_size);   
}   }  
