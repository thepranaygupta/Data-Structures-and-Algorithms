//Problem Statement
//Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.


/*
Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
Example 2:

Input: 
n = 2, arr1[] = [10, 12] 
m = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays 
we get 5 10 12 18 20.


Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.
 

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= n, m <= 5*104
0 <= arr1i, arr2i <= 107
*/

/*
1. Method 1




Algorithm: 


1) Iterate through every element of ar2[] starting from last 

   element. Do following for every element ar2[i]

    a) Store last element of ar1[i]: last = ar1[i]

    b) Loop from last element of ar1[] while element ar1[j] is 

       greater than ar2[i].

          ar1[j+1] = ar1[j] // Move element one position ahead

          j--

    c) If any element of ar1[] was moved or (j != m-1)

          ar1[j+1] = ar2[i] 

          ar2[i] = last

In above loop, elements in ar1[] and ar2[] are always kept sorted.


*/

/*
Method 2:




The solution can be further optimized by observing that while traversing the two sorted arrays parallelly, if we encounter the jth second array element is smaller than ith first array element, then jth element is to be included and replace some kth element in the first array. This observation helps us with the following algorithm




Algorithm


1) Initialize i,j,k as 0,0,n-1 where n is size of arr1 

2) Iterate through every element of arr1 and arr2 using two pointers i and j respectively

    if arr1[i] is less than arr2[j]

        increment i

    else

        swap the arr2[j] and arr1[k]

        increment j and decrement k



3) Sort both arr1 and arr2 
*/
/*
Method 3:




Algorithm:


1) Initialize i with 0

2) Iterate while loop until last element of array 1 is greater than first element of array 2

          if arr1[i] greater than first element of arr2

              swap arr1[i] with arr2[0]

              sort arr2

          incrementing i 
 */

//Implementation
#include<bits/stdc++.h>
using namespace std;
class Solution{
	public:
    	long long findNth(long long N)
    {
        long long ans=0;
        long long temp = 1;
        long long n = N;
        while(n>0){
            ans += (temp*(n%9));
            n=n/9;
            temp = temp*10;
        }
        return ans;
    }
};

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long n , ans;
		cin>>n;
		Solution obj;
		ans = obj.findNth(n);
		cout<<ans<<endl;
	}
}

//code is contributed by krishna_6431
