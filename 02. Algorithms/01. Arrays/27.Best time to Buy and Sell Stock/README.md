# Best Time To Buy and Sell Stocks🤑

**Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/**

![image](https://user-images.githubusercontent.com/93209316/184504891-d6b768b4-8f52-45f5-b888-5cfad513c861.png)


**Lets Analyse this test case once**

Input: prices = [7,1,5,3,6,4]
Output: 5

* Satring day the price is 7, which is greater so this wont be best time to buy and sell stocks
* as we move further if we buy the stock on 2nd day which is *leastSoFar* and sell on 3rd day. the *profitsofar* will be 5-1 = 4
* but this isnt *bestOverallProfit*
* the next option is to buy the stocks on 2nd day and sell it on 5th day. in this case the profit will be 6-1 = 5 which is greater than *profiteSofar* so this will be the *bestOverallProfit*


If we see carefully the approach will be :
1. We will maintain 3 variables leastSofar , profitSofar, bestOverallProfit
2. While traversing from index 0 till the end of an array, will update *leastSofar* if prices[i] < leastSoFar
3. After that we will calculate *profitSoFar* by doing pricaes[i] - leastSofar if this value is greater than *bestOverallProfit** then will update variable *bestOverallProfit*
4. In the end we will return Max Profit which is *(beastOverallProfit)*

**Solution :-**

```
class Solution {
    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int profitIfSoldToday = 0;
        int overallProfit = 0;
        
        for(int i=0; i < prices.length;i++){
            if(prices[i] < leastSoFar){
                leastSoFar = prices[i];   
            }
            profitIfSoldToday = prices[i] - leastSoFar;
            if(profitIfSoldToday > overallProfit){
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }
}
```
