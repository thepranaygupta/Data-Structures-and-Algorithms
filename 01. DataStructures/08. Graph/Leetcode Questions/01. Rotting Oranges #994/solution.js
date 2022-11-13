// problem link https://leetcode.com/problems/rotting-oranges/

var orangesRotting = function(grid) {
  // make height and width
    //   make queue
    //make fresh variable
    
    const height = grid.length;
    const width = grid[0].length;
    let freshOranges = 0;
    const BFSQueue = [];
    let minutes = 0;

    for(let i = 0; i < height; i++) {
        for(let j = 0; j < width; j++) {
            if(grid[i][j]  === 2) BFSQueue.push([i, j]);
            if(grid[i][j] === 1) freshOranges++; 
        }
    }

    // bfs traversal 
    while(BFSQueue.length) {

        let size = BFSQueue.length;
        for(let i = 0; i < size; i++) {
        let [row, column] = BFSQueue.shift();
        explore(row - 1, column);
        explore(row + 1, column);
        explore(row, column - 1);
        explore(row, column + 1);
        }
        if(BFSQueue.length > 0) {
            minutes++;
        } 
    }

    function explore(row, column) {

        if(
            row < 0 ||
            column < 0 ||
            row > height - 1 ||
            column > width - 1 || 
            grid[row][column] !== 1
        ) return;

        freshOranges--;
        grid[row][column] = 2;
        BFSQueue.push([row, column]);
    }

    return !freshOranges ? minutes : -1;
};
