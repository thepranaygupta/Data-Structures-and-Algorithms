class Solution {
public:
    int minCost(string s, vector<int>& cost) {
        int ans = 0;
        int n = s.size();
        
        int left = 0;
        while (left<n) {
            int totalCost = 0;
            int maxCost = 0;
            int right = left;
            while (right < n && s[left] == s[right]) {
                totalCost += cost[right];
                maxCost = max(maxCost, cost[right]);
                right++;
            }
            ans += (totalCost-maxCost);
            left = right;
        }
        return ans;
    }
};