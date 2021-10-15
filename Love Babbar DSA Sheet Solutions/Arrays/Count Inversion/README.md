# [Count Inversion](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)

# Problem Statement

# Given an array of integers. Find the Inversion Count in the array.

# Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.

# Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

# Example 1:

#

# Input: N = 5, arr[] = {2, 4, 1, 3, 5}

# Output: 3

# Explanation: The sequence 2, 4, 1, 3, 5

# has three inversions (2, 1), (4, 1), (4, 3).

# Solution in C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution{
  public:
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
   long long crossInversion(long long array[], long long s, long long e)
{
    //something happening wrong with this code
    long long i = s;
    long long m = (s + e) / 2;
    long long j = m + 1;
    vector<long long> temp;
    long long count = 0;
    while (i <= m and j <= e)
    {
        if (array[i] <= array[j])
        {
            temp.push_back(array[i]);
            i++;
        }
        else
        {
            count += m - i+  1;
            temp.push_back(array[j]);
            j++;
        }
    }
    //this loop add remaining elements from first array
    while (i <= m)
    {
        temp.push_back(array[i++]);
    }
    //this loop add remaining elements from second array
    while (j <= e)
    {
        temp.push_back(array[j++]);
    }
    //copy back all elements to original array
    long long k = 0;
    for (long long idx = s; idx <= e; idx++)
    {
        array[idx] = temp[k++];
    }
    return count;
}

    long long inversion_Count(long long array[], long long s, long long e)
    {
    //base case
    if (s >= e)
    {
        return 0;
    }
    //rec case
    long long mid = (s + e) / 2;
    long long c1 = inversion_Count(array, s, mid);
    long long c2 = inversion_Count(array, mid + 1, e);
    long long ci = crossInversion(array, s, e);
    return c1 + c2 + ci;
    }
    long long int inversionCount(long long array[], long long N)
    {
        return inversion_Count(array,0,N-1);
    }

};

int main() {

    long long T;
    cin >> T;

    while(T--){
        long long N;
        cin >> N;

        long long A[N];
        for(long long i = 0;i<N;i++){
            cin >> A[i];
        }
        Solution obj;
        cout << obj.inversionCount(A,N) << endl;
    }

    return 0;
}

```

# this code is contributed by krishna6431
