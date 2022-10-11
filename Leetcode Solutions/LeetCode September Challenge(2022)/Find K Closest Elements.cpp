class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int left = 0, right = n - k, startIdx = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid+k == n || x - arr[mid] <= arr[mid+k] - x) {
                startIdx = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return vector<int>(arr.begin() + startIdx, arr.begin() + startIdx + k);
    }
};