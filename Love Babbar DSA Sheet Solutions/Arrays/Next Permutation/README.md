# [Next Permutation](https://leetcode.com/problems/next-permutation/)
# Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

# If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

# The replacement must be in place and use only constant extra memory.

 

# Example 1:

# Input: nums = [1,2,3]
# Output: [1,3,2]
# 
# Example 2:
# 
# Input: nums = [3,2,1]
# Output: [1,2,3]


# Solution in C++
```cpp
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size(), flag = 0;
        for(int i=0 ; i < n-1; i++)
        {
            if(nums[i+1] > nums[i])
            {
                flag = 1;
                break;    
            }
        }
        if(flag == 0)
        {
            int temp;
            for(int i = 0; i < n/2;i++)
            {
                temp = nums[i];
                nums[i] = nums[n-i-1];
                nums[n-i-1] = temp;
            }
        }
        else
        {
            int n = nums.size();
            for(int i=n-1 ; i >= 0; i--)
            {
                for(int a = n-1; a >i;a--)
                {
                    if(nums[a] > nums[i])
                    {
                        int temp = nums[i];
                        nums[i] = nums[a];
                        nums[a] = temp;
                        sort(nums.begin()+i+1, nums.end());
                        return;
                    }
                }
            }
            return;
            
        }
    }
};
```