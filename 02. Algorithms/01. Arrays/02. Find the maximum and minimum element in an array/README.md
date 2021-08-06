### Problem Link: https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1#

- ## Approach 1: Traverse Linearly, TC = O(n)
```java
//User function Template for Java

/*
 class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} */

class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
        pair mm = new pair(a[0], a[0]);
        // mm.first = a[0];
        // mm.second = a[0];
        for(long i: a)
        {
            mm.first = Math.min(mm.first, i);
            mm.second = Math.max(mm.second, i);
        }
        return mm;
    }
}
```
