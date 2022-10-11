class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int>leftProd(nums.size(),1);
        vector<int>rightProd(nums.size(),1);
        for(int i=1;i<nums.size();i++)
            leftProd[i]=leftProd[i-1]*nums[i-1];
        for(int i=nums.size()-1;i>=1;i--)
            rightProd[i-1] = rightProd[i]*nums[i];
        for(int i=0;i<nums.size();i++)
            nums[i] = leftProd[i]*rightProd[i];
        return nums;
    }
};