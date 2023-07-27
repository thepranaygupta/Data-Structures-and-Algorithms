/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {
    let result = 0;    
    const board = [];
    for(let i = 0; i < n; i++) {
        const temp = [];
        for(let j = 0; j < n; j++) {
            temp[j] = '.';
        }
        board.push(temp);
    }
    const colHash = new Set();
    const posDiagonal = new Set();
    const negDiagonal = new Set();

    function backtrack(r) {
        if(r === n) {
            result++;
            return;
        }

        for(let c = 0; c < n; c++) {
            if(colHash.has(c) || posDiagonal.has(r+c) || negDiagonal.has(r-c)) continue;

            colHash.add(c);
            posDiagonal.add(r+c);
            negDiagonal.add(r-c);
            board[r][c] = 'Q';

            backtrack(r+1);

            colHash.delete(c);
            posDiagonal.delete(r+c);
            negDiagonal.delete(r-c);
            board[r][c] = '.';
        }
    }

    backtrack(0);
    return result;
};
