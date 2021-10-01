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