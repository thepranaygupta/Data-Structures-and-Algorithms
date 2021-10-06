"""
You are given weights and values of N items, put these items in a knapsack of capacity W to
get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values
and weights associated with N items respectively. Also given an integer W which represents knapsack capacity,
find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
"""
def knapSack(w, wt, val, n):
    dp = [[0 for i in range(w+1)]for i in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,w+1):
            if j >= wt[i-1]:
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-wt[i-1]] + val[i-1])
                # if the j is greater than weight then u can pick the val or not pick the value
            else:
                dp[i][j] = dp[i-1][j]
    return dp[n][w]

"""
TC - O(N * W)
SC - O(N * W)
"""