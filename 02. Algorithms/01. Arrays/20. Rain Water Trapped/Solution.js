/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    
  let left = 0;
  let right = height.length - 1;
  let current = left;
  let maxLeft = 0;
  let maxRight = 0;
  let water = 0;

  while(left < right) {
      const waterBlock = Math.min(maxLeft, maxRight) - height[current];
      if(waterBlock > 0) {
          water += waterBlock;
      }
      maxLeft = Math.max(maxLeft, height[left]);
      maxRight = Math.max(maxRight, height[right]);

      if(maxLeft <= maxRight) {
          left++;
          current = left;
      } else {
          right--;
          current = right;
      }
  }

  return water;
};
