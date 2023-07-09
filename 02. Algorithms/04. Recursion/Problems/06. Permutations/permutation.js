/**
 * 
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    function dfs(nums) {
        if(nums.length === 1) return [nums.slice(0)];

        const result = [];
        for(let i = 0; i < nums.length; i++) {
            const n = nums.shift();
            const permutations = dfs(nums);
            permutations.forEach((permutation) => {
                result.push([...permutation, n]);
            });
            nums.push(n);
        }
        return result;
    } 

    return dfs(nums);
};
