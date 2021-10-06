"""
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
"""
def coinChange(self, arr, s: int) -> int:
    n = len(arr)
    dp = [[0 for i in range(s+1)]for i in range(n+1)]
    for i in range(s+1):
        dp[0][i] = float("inf") # Because with 0 coins you can not make any number
    for i in range(1,s+1):
        if i%arr[0]==0:
            dp[1][i] = i//arr[0] # With 1 coin you either can divide with it or not
        else:
            dp[1][i] = float('inf')
    for i in range(2,n+1):
        for j in range(1,s+1):
            if j >= arr[i-1]:
                dp[i][j] = min(dp[i-1][j],1+dp[i][j-arr[i-1]]) # To calculate min. number
            else:
                dp[i][j] = dp[i-1][j]
    if dp[n][s] == float('inf'):
        return -1
    return dp[n][s]
    
"""
TC = o(n*s)
SC = o(n*s)
"""