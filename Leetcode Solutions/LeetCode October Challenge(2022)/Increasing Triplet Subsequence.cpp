class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
         int n= nums.size();
        int left=INT_MAX;
        int middle=INT_MAX;
        for(int i=0;i<n;i++){
            int right=nums[i];
            if(right<left){
                left=right;
            }
            else if(right<middle && right > left){
                middle = right;
            }
            else if(right>middle&& right>left)return true;
        }
        return false; 
    }
};