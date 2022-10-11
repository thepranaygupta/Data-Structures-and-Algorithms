class Solution {
public:
    bool searchMatrix(vector<vector<int>>& M, int T) {
        int y = M.size(), i = 0, j = M[0].size() - 1;
        while (i < y && ~j) {
            int cell = M[i][j];
            if (cell == T) return true;
            else if (cell > T) j--;
            else i++;
        }
        return false;
    }
};