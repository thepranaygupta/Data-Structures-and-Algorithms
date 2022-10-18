class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        auto first = nums.begin(), last = nums.end();
        auto target = first + k - 1;
        while (first < last) {
            auto mid = partition(first, last - 1, [last] (int e) { return e > *(last - 1); } );
            swap(*mid, *(last - 1));
            if (mid < target) {
                first = mid + 1;
            } else if (mid > target) {
                last = mid;
            } else {
                break;
            }
        }
        return *target;
    }
};