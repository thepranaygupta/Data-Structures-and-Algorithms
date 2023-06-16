/**
 * https://leetcode.com/problems/richest-customer-wealth/
 * 
 * Time O(n*m) | Space O(1)
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function(accounts) {
    
    let maxWealth = 0;
    for(let i = 0; i < accounts.length; i++) {
        let currentWealth = 0;
        for(let j = 0;  j < accounts[i].length; j++) {
            currentWealth += accounts[i][j];
        }
        maxWealth = Math.max(maxWealth, currentWealth);
    }

    return maxWealth;
};
