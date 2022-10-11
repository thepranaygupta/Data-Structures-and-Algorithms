class Solution {
public:
    int trap(vector<int>& height) {
        int a = 0, b = height.size() - 1, c = 0, d = 0;
        while (a < b) {
            while (a < b && height[a] <= d) {
                c += d - height[a++];
            }
            while (a < b && height[b] <= d) {
			c += d - height[b--];
            }
            d = min(height[a], height[b]);
        }
        return c;
    }
};