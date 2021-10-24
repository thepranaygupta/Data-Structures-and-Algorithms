//Problem Statement
//Given an even number N (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only the pair whose minimum value is the smallest among all the minimum values of pairs.


/*
Example 1:

Input: N = 74
Output: 3 71
Explaination: There are several possibilities 
like 37 37. But the minimum value of this pair 
is 3 which is smallest among all possible 
minimum values of all the pairs.
Example 2:

Input: 4
Output: 2 2
Explaination: This is the only possible 
prtitioning of 4.
 
our Task:
You do not need to read input or print anything. Your task is to complete the function primeDivision() which takes N as input parameter and returns the partition satisfying the condition.

Expected Time Complexity: O(N*log(logN))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104  
*/

//Implementation

#include <bits/stdc++.h>
using namespace std;

class Solution{
public:
    vector<int> primeDivision(int n){
        vector<int>ans;
        vector<int>prime_no;
        bool prime[n+1]={0};
        int i,j;
        for(i=2;i*i<=n;i++){
            if(prime[i]==0){
                for(j=i*i;j<=n;j+=i){
                    prime[j]=1;
                }
            }
        }
        for(i=2;i<=n;i++){
            if(prime[i]==0){
                prime_no.push_back(i);
            }
        }
        for(i=0;i<prime_no.size();i++){
            int temp=prime_no[i];
            for(j=prime_no.size();j>=i;j--){
                if(n-temp==prime_no[j]){
                    ans.push_back(temp);
                    ans.push_back(prime_no[j]);
                    break;
                }
            }
            
        }
        return ans;
        
    }
    
    
};

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        
        Solution ob;
        vector<int> ans = ob.primeDivision(N);
        cout<<ans[0]<<" "<<ans[1]<<"\n";
    }
    return 0;
}

//Code is Contributed By krishna_6431
