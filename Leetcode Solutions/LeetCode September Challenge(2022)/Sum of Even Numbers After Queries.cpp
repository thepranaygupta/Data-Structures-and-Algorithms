class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries, vector<int> ans = {}) {
        for(auto q : queries){
            nums[q[1]] += q[0];
            ans.push_back(accumulate(nums.begin(), nums.end(), 0, [&](const int &s, const int &y) { return s + (!(y % 2) ? y : 0);}));
        }
        return ans;
    }
};