## 12 . Pick from both sides
## https://www.interviewbit.com/problems/pick-from-both-sides/

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.

```c++
int Solution::solve(vector<int> &A, int B) {
if(B > A.size())
        return -1;
    
    int max_val = 0;
    for(int i=0;i<B;i++){
        max_val += A[i];
    }
    
    int j = B-1;
    int ans = max_val;
    for(int i=A.size()-1;i>A.size()-B-1;i--){
        ans = max(ans, max_val - A[j] + A[i]);
        max_val = max_val - A[j] + A[i];
        j--;
    }
    return ans;

 }
```

## Asked in MEDIA.NET
