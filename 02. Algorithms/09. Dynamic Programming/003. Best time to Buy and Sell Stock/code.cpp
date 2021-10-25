class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int cost = INT_MAX, sell=0;
        
        for(int i:prices)
        {
            cost = min(cost,i);
            sell = max(sell,i-cost) ;
        }
        
        return sell ;
    }
};