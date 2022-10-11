class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<set<int>> rows(9), cols(9), blocks(9);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') continue;
                
                int curr = board[i][j] - '0';
                if (rows[i].count(curr) || cols[j].count(curr) || blocks[(i/3)*3+j/3].count(curr)) 
                    return false;
                
                rows[i].insert(curr);
                cols[j].insert(curr);
                blocks[(i/3)*3+j/3].insert(curr);
            }
        }
        
        return true;
    }
};