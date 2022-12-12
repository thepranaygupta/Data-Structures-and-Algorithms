// problem link https://leetcode.com/problems/sort-colors
// submission link https://leetcode.com/problems/sort-colors/submissions/852815202/

function sortColors(nums) {
 
 let i = 0;
 let l = 0;
 let r = nums.length - 1;

 while(i <= r) {
     const num = nums[i];
     if(num ===  0) {
         swap(nums,i,l);
         i++;
         l++;
     } else if(num === 2) {
         swap(nums,i,r);
         r--;
     } else {
         i++;
     }
 } 

 return nums;
}

function swap(nums,i,j) {
    [nums[i], nums[j]] = [nums[j],nums[i]];
}
