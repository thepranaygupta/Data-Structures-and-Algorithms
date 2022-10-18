class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        ios::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
                
        int sum = accumulate(nums.begin(), nums.end(), 0, [](int &x, int &y){
            return (y & 1) ? x : x + y;
        });
        vector<int> ans;
        int tmp, t0, t1;
        
        for(vector<int> &v : queries){
            t0 = v[0];
            t1 = v[1];
            tmp = nums[t1] + t0;
            if(nums[t1] & 1){ //if original even
                if(!(tmp & 1)) sum += tmp;
            }
            else{ //if original odd
                sum += (tmp & 1) ? -nums[t1] : t0;
            }
            nums[t1] = tmp;
            ans.push_back(sum);
        }
        return ans;
    }
};