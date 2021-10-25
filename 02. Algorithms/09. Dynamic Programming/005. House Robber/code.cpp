class Solution {
public:
    int rob(vector<int>& nums) {
        int sz = nums.size();
        vector<int> dp(sz);
        for (int i = 0; i < sz; i++) {
            if (i == 0) {
                dp[i] = nums[0];
            } else if (i == 1) {
                dp[i] = max(nums[1], nums[0]);
            } else {
                dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        return dp[sz-1];
    }
};