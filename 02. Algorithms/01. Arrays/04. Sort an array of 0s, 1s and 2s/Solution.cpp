// https://leetcode.com/problems/sort-colors/
class Solution {
public:
    void sortColors(vector<int>& a) {
        int n = a.size();
        int low=0, mid=0, high=n-1;
        while(mid<=high) {
            if(a[mid]==0)
            {
                swap(a[mid++],a[low++]);
            }
            else if(a[mid]==1)
            {
                mid++;
            }
            else
            {
                swap(a[mid],a[high--]);
            }
        }
    }
};
