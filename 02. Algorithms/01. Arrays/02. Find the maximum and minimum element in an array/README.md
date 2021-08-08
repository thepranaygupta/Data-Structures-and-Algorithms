### Problem Link: https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1#
### Editorial Link: https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/


- ## Approach 1: Sort the Array, TC = O(nlog(n))
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
        Arrays.sort(a);
        mm.first = a[0];
        mm.second = a[a.length - 1];
        return mm;
    }
}
```

- ## Approach 2: Traverse Linearly, TC = O(n)
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

- ## Approach 3: Tournament Method (Divide and Conquer), TC = O(n) but lesser number of comparisons
Divide the array into two parts and compare the maximums and minimums of the two parts to get the maximum and the minimum of the whole array.
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
        //Write your code here
        // MinMax(array, low, high)
        return MinMax(a, 0, (int)n-1);
    }
    
    static pair MinMax(long a[], int low, int high)
    {
        pair minmax = new pair(a[0], a[0]);
        pair mml = new pair(a[0], a[0]);
        pair mmr = new pair(a[0], a[0]);
        
        // if there is only one element
        if(low == high)
        {
            minmax.first = a[low];
            minmax.second = a[low];
            return minmax;
        }
        
        // if there are two elements
        if(low == high-1)
        {
            minmax.first = Math.min(a[low], a[high]);
            minmax.second = Math.max(a[low], a[high]);
            return minmax;
        }
        
        // if there are more than 2 elements
        int mid = (low + high)/2;
        mml = MinMax(a, low, mid);
        mmr = MinMax(a, mid+1, high);
        
        minmax.first = Math.min(mml.first, mmr.first);
        minmax.second = Math.max(mml.second, mmr.second);
        return minmax;
    }
}
```
