/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    
    let top = 0;
    let bottom = matrix.length  - 1;
    let left = 0;
    let right = matrix[0].length - 1;
    const result = [];
   while(true) {

       for(let i = left; i <= right; i++) {
        result.push(matrix[left][i]);
       }
       if(left > right) {
           return result;
       }
       top++;
       for(let i = top; i <= bottom; i++) {
           result.push(matrix[i][right]);
       }
       if(top > bottom) {
           return result;
       }
       right--;
       for(let i = right; i >=  left; i--) {
           result.push(matrix[bottom][i]);
       }
       if(right < left) {
           return result;
       }
       bottom--;
       for(let i = bottom; i >= top; i--) {
           result.push(matrix[i][left]);
       }
       if(bottom < top) {
           return result;
       }
       left++;
   }
};
