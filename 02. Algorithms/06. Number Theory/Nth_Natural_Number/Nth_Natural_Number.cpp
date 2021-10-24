//Problem Statement
//Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.


/*
Example 1:
Input:
N = 8
Output:
Explanation:
After removing natural numbers which contains
digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
and 8th number is 8.
Example 2:
Input:
N = 9
Output:
10
Explanation:
After removing natural numbers which contains
digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
and 9th number is 10.
 
Your Task:
You don't need to read input or print anything. Complete the function findNth() which accepts an integer N as input parameter and return the Nth number after removing all the numbers containing digit 9.
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ N ≤ 10^12
*/

/*
Naive Approach: The simplest approach to solve the above problem is to iterate up to N and keep excluding all numbers less than N containing the digit 9. Finally, print the Nth natural number obtained.
Time Complexity: O(N)
Auxiliary Space: O(1)
*/

/*
Efficient Approach: The above approach can be optimized based on the following observations: 
It is known that, digits of base 2 numbers varies from 0 to 1. Similarly, digits of base 10 numbers varies from 0 to 9.
Therefore, the digits of base 9 numbers will vary from 0 to 8.
It can be observed that Nth number in base 9 is equal to Nth number after skipping numbers containing digit 9.
So the task is reduced to find the base 9 equivalent of the number N.
Follow the steps below to solve the problem:
Initialize two variables, say res = 0 and p = 1, to store the number in base 9 and to store the position of a digit.
Iterate while N is greater than 0 and perform the following operations:
Update res as res = res + p*(N%9).
Divide N by 9 and multiply p by 10.
After completing the above steps, print the value of res.
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
