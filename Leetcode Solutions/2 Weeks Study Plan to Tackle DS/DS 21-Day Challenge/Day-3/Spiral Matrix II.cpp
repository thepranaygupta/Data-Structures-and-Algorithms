class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
       vector<vector<int>> matrix(n, vector<int>(n));
       for (int num = 0, left = 0, right = n - 1, top = 0, bottom = n - 1;
            left <= right && top <= bottom;
            ++left, --right, ++top, --bottom) {
            for (int j = left; j <= right; ++j) {
                matrix[top][j] = ++num;
            }
            for (int i = top + 1; i < bottom; ++i) {
                matrix[i][right] = ++num;
            }
            for (int j = right; top < bottom && j >= left; --j) {
                matrix[bottom][j] = ++num;
            }
            for (int i = bottom - 1; left < right && i >= top + 1; --i) {
                matrix[i][left] = ++num;
            }
        }
        return matrix;
    }
};