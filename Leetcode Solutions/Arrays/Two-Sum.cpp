/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        //bruteforce
        int n = nums.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return{i, j};
                }
            }
        }
        //unordered map
        /*int n = nums.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++)
        {
            int x = nums[i];
            int y = target - x;
            if (m.find(y) != m.end())
            {
                return{i, m[y]};
            }
            m[nums[i]] = i;
        }*/
        return{-1, -1};
    }
};
// @lc code=end