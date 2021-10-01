# **[Chocolate Distribution Problem](https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#)**
## When you will read the Qs and see the TCs then you'll realise actual Q is **Make a subsequence of size M such that MAX-MIN in that subsequence is MINIMUM than all the possible subsequence.**

## My Intution : - Sliding Window Extra Space TC - O(N Log N) SC - O(1)
## **Why this Q is demanding subSequence ?**
This is because Q says we have to find Minimum difference btw MAX & MIN and this is possible when you do 2ndMINIMUM - MINIMUM but as it is also mention that each student should get atleast one choclatePacket which means you have to find subsequence of length M where when we sort that subSequence than all the inner elements (elements btw 1 to M-2) are the packets distributed to all the M students.  
## **Why we sorted ?**
Here we sorted because:- 
- we have to find MINIMUM DIFF btw MAX & MIN, this is only possible when MAX and MIN will lie close to each other in Number Line so elements btw MIN & MAX will also be a part of subsequence.
- So basically when we get subsequence they are sorted, so end - start give us the check of our ANS.

```java
class Solution
{
    public long findMinDiff (ArrayList<Long> arr, long n, long m)
    {
        // your code here
        Collections.sort(arr);
        int start=0,end=(int)m-1;
        long ans=Long.MAX_VALUE;
        while(end < n){
            ans=Math.min(ans,arr.get(end)-arr.get(start));
            start++;
            end++;
        }
        return ans;
    }
}
```

