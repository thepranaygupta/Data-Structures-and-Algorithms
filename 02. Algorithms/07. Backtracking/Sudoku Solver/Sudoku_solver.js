/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * Recursion | Backtracking.
 * n won't exeed 9. So, It's ok
 * Time O(n^n) | Space O(n)
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function(board) {
    

    const ROWS = board.length;
    const COLS = board[0].length;

    const isValid = (num, row, col) => {
        // check the row.
        for(let i = 0; i < 9; i++) {
            if(board[row][i] === num) return false;
        }

        // check the col.
        for(let i = 0; i < 9; i++) {
            if(board[i][col] === num) return false; 
        }

        // check the 3*3 grid.
        const rowStart = Math.floor(row/3) * 3;
        const colStart = Math.floor(col/3) * 3;
        for(let i = rowStart; i < rowStart+3; i++) {
            for(let j = colStart; j < colStart+3; j++) {
                if(board[i][j] === num) return false;
            }
        }

        // we can use the number.
        return true;

    }

    const dfs = (row,col) => {
        if(row === ROWS) return true;

        const nextRow = col >= 8 ? row + 1 : row;
        const nextCol = col >= 8 ? 0 : col + 1;

        if(board[row][col] !== '.') {
            if(dfs(nextRow, nextCol)) return true;
        }
        if(board[row][col] === '.') {
            for(let i = 1; i < 10; i++) {
                if(isValid(i.toString(), row, col)) {
                    board[row][col] = i.toString();
                    if(dfs(nextRow, nextCol)) return true;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    dfs(0,0)
};
