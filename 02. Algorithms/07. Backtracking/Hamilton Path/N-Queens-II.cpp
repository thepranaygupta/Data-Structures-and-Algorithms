//problem link:https://leetcode.com/problems/n-queens-ii/
//Time complexity : best and average case O(n*n)    
//worst case:O(n!)
class Solution {
public:
     bool issafe(vector<string> &board,int n,int row,int col)
{
    for(int i=0;i<col;i++)
    {
        if(board[row][i]=='Q')
        {
            return false;
        }
    }
    for(int i=row,j=col; i>=0 && j>=0; i--,j--)
    {
        if(board[i][j]=='Q')
        {
            return false;
        }
    }
    for(int i=row,j=col; i<n && j>=0; i++,j--)
    {
        if(board[i][j]=='Q')
        {
            return false;
        }
    }
    return true;
}
void nqueen(vector<vector<string>> &ans,vector<string> &board,int n,int col)
{
    if(col==n)
    {
       ans.push_back(board);
    }
    for(int row=0;row<n;row++)
    {
        if(issafe(board,n,row,col))
        {
            board[row][col]='Q';
            nqueen(ans,board,n,col+1);
            board[row][col]='.';
        }
    }
}
    int totalNQueens(int n) {
         vector<vector<string>>ans;
        vector<string>board(n);
        string s(n,'.');
        for (int i = 0; i < n; i++)
        {
            board[i]=s;
        }
        nqueen(ans,board,n,0);
        return ans.size();
    }
}; 