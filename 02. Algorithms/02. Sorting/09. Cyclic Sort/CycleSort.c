#include<stdio.h>  
void sort(int a[], int n)  
{  
    int writes = 0,start,element,pos,temp,i;  
   
    for (start = 0; start <= n - 2; start++) {  
        element = a[start];  
        pos = start;  
        for (i = start + 1; i < n; i++)  
            if (a[i] < element)  
                pos++;  
        if (pos == start)  
            continue;  
        while (element == a[pos])  
            pos += 1;  
        if (pos != start) {  
            //swap(element, a[pos]);  
        temp = element;  
        element = a[pos];  
            a[pos] = temp;    
            writes++;  
        }  
        while (pos != start) {  
            pos = start;  
            for (i = start + 1; i < n; i++)  
                if (a[i] < element)  
                    pos += 1;  
            while (element == a[pos])  
                pos += 1;  
            if (element != a[pos]) {  
              temp = element;  
          element = a[pos];  
              a[pos] = temp;    
                writes++;  
            }  
        }  
    }  
   
 }  
   
int main()  
{  
    int a[] = {1, 9, 2, 4, 2, 10, 45, 3, 2};  
    int n = sizeof(a) / sizeof(a[0]),i;  
    sort(a, n);  
    printf("After sort, array : ");  
    for (i = 0; i < n; i++)  
        printf("%d  ",a[i]);  
    return 0;  
}  
