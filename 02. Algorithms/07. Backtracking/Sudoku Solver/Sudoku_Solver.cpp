/*
Link to Question - https://leetcode.com/problems/sudoku-solver/

Question - Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

*/

#include<bits/stdc++.h>

class Solution {
public:
    bool check(vector<vector<char>> &board, int i, int j, char val)
{
    int row = i - i%3, column = j - j%3;
        
    for(int x=0; x<9; x++) // check row
        if(board[x][j] == val)
            return false;
        
    for(int y=0; y<9; y++) // check col
        if(board[i][y] == val)
            return false;
        
    for(int x=0; x<3; x++)  // check sqrt matrix
    for(int y=0; y<3; y++)
        if(board[row+x][column+y] == val)
            return false;
        
    return true;
}
    
    bool solve(vector<vector<char>> &board, int i, int j){
        if(i==9)  // if we have reached the end, return true
            return true;
        if(j==9)
            return solve(board,i+1,0);
        if(board[i][j] != '.')
            return solve(board,i,j+1);
        
        // check for all possible combinations
        for(char c='1'; c<='9'; c++){
            if(check(board,i,j,c)){  // check whether is the arrangement is valid or not
                board[i][j] = c;
                if(solve(board, i, j+1))  
                    return true;
                board[i][j] = '.';   // if previous arrangement was not valid, backtrack
            }
        }
        return false;
    }
    
    void solveSudoku(vector<vector<char>>& board) {
        solve(board,0,0);  // call the solve method
    }
};