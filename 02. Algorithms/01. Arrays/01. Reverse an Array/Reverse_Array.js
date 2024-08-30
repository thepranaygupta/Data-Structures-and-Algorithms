// Method 1
// time complexity: O(n)

let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let res = [];
for (let i = arr.length - 1; i >= 0; i--) {
  res.push(arr[i]);
}
console.log(res);

// Method 2
// using two pointer approach
// time complexity: O(n)

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let left = 0,
  right = arr.length - 1;
while (left < right) {
  let temp = arr[left];
  arr[left] = arr[right];
  arr[right] = temp;
  left++;
  right--;
}
console.log(arr);

// Method 3
// using in-built functions
// time complexity: O(n)
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
arr.reverse();
console.log(arr);

// Method 4
// using recursion
// time complexity: O(n)
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
function reverseArray(arr, start, end) {
  if (start >= end) return;
  let temp = arr[start];
  arr[start] = arr[end];
  arr[end] = temp;
  reverseArray(arr, start + 1, end - 1);
}
reverseArray(arr, 0, arr.length - 1);
console.log(arr);
