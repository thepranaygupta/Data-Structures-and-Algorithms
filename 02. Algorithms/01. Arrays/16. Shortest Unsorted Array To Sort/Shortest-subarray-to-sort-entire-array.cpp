//finding shortest subarray that, when sorted, can sort the entire array 

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int i=-1, n, p1 = -1, p2 = n-1, flag = 1;
    cin>>n;
    int a[n];
    while(++i<n)
    {
        cin>>a[i];
        if(i>0 && flag)
            if(a[i]<a[i-1])
               {
                   p1 = i;
                   flag = 0;//first instance of desecent from beginning of array (moving rightwards)
               }   
    }
    if(p1 == -1)
       cout<<"0 , 0"<<endl;
    else
    {
        i = n;
        while(i--)
            if(a[i]<a[i-1])
            {
                p2 = i;
                break; //first instance of descent from end of array (moving leftwards)
            }     
        
        int min = a[p1]; //or a[0]
        int max = a[p1];
        i = p1;
        while(++i<p2+1)
        {
            if(a[i]<min)
               min = a[i]; //finding min element in that sub-array

            if(a[i]>max)
               max = a[i];  //finding max element in that sub-array 
        }

        //we have max and min of alleged shortest array

        i = -1; int j = n;
        while(i++<p1 || j-->p2)
        {
            if(a[i]>min && i<p1) //checking for element smaller than min in previous indices
                p1 = i;
                           
            if(a[j]<max && j>p2) //checking for element larger than max in succeeding indices
                p2 = j;
        }
        
        cout<<p1<<" "<<p2<<endl; //found the required indices
        
    }    

}
