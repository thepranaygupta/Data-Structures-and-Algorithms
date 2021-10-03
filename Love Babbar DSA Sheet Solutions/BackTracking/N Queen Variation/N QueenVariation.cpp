/*
The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens’ placement, 
where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. 

Input 1:
1
Output 1:
[1]
Explaination 1:
Only one queen can be placed 
in the single cell available.
Example 2:

Input 2:
4
Output 2:
[2 4 1 3 ] [3 1 4 2 ]
Explaination 2:
These are the 2 possible solutions.
*/

class Solution{
public:
    bool isSafe(int N,vector<vector<int>> &queen,int i,int j){
        for(int k=0;k<i;k++){
            if(queen[k][j]==1){
                return false;
            }
        }
        int row=i,col=j;
        while(row>=0&&col>=0){
            if(queen[row][col]==1){
                return false;
            }
            row--;
            col--;
        }
        row=i;
        col=j;
        while(row>=0 && col<N){
            if(queen[row][col]==1){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
    void nQueen(int r,int N,vector<int> &curr,vector<vector<int>> &ans,vector<vector<int>> &queen){
        if(r==N){
            ans.push_back(curr);
            return;
        }
        for(int col = 0;col<N;col++){
            if(isSafe(N,queen,r,col)){
                queen[r][col]=1;
                curr.push_back(col+1);
                nQueen(r+1,N,curr,ans,queen);
                queen[r][col]=0;
                curr.pop_back();
            }
        }
    }
    vector<vector<int>> nQueen(int n) {
        // code here
        vector<vector<int>> ans;
        vector<vector<int> > queen(n,vector<int>(n,0));
        vector<int> curr;
        nQueen(0,n,curr,ans,queen);
        return ans;
    }
};
