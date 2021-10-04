# [Kadane Algorithms](https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1)

# Problem Statement

# Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.

# Example 1:
# Input:

# N = 5

# Arr[] = {1,2,3,-2,5}

# Output:

# 9

# Explanation:

# Max subarray sum is 9

# of elements (1, 2, 3, -2, 5) which

# is a contiguous subarray.

# Solution in C++

```cpp
#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long long maxSubarraySum(int arr[], int n){

        long long maxSum = INT_MIN;
        long long currSum = 0;

        for(int i=0; i<n; i++)
        {
            currSum += arr[i];

            if(currSum > maxSum)
                maxSum = currSum;

            if(currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
};

int main()
{
    int t,n;

    cin>>t; //input testcases
    while(t--) //while testcases exist
    {

        cin>>n; //input size of array

        int a[n];

        for(int i=0;i<n;i++)
            cin>>a[i]; //inputting elements of array

        Solution ob;

        cout << ob.maxSubarraySum(a, n) << endl;
    }
}

```

# this code is contributed by krishna6431
