**A BRIEF EXPLANATION OF KADANE'S ALGORITHM**

Given an integer array, find the contiguous subarray (containing at least one number) with the largest sum or in other words the maximum sum contiguous subarray and print its sum. (**USING KADANE'S ALGORITHM**)

Example:<br>
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]<br>
Output: 6<br>
Explanation: [4,-1,2,1] has the largest sum = 6.<br>

Now,<br>
What is a subarray?<br>
An array is a contiguous memory block so, a subarray is a slice of a contiguous array that maintains the order of the elements. 
To understand this let us consider an array:<br>
<br>
Ex: arr = {1,2,3,4,5}<br>
For this array, the sub-arrays are:<br>
For element at 0th index	{1}, {1,2}, {1,2,3}, {1,2,3,4}, {1,2,3,4,5}<br>
For element in 1st index	{2}, {2,3}, {2,3,4}, {2,3,4,5}<br>
For element in 2nd index	{3}, {3,4}, {3,4,5}<br>
For element in 3rd index	{4}, {4,5}<br>
For element in 4th index	{5}<br>


Approach:<br>
**Brute force solution:**<br>
The brute force solution calculates the sum of each subarray and then compares the results to determine the maximum sum of all subarray sums. But the time complexity is O(n^2) at the very best.<br>

**Kadane's Algorithm:**<br>
Kadane’s algorithm is an iterative dynamic programming algorithm which is used to search for a maximum sum contiguous subarray within a one-dimensional numeric array. A simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array and keep track of the maximum sum contiguous subarray among all positive segments. Kadane’s algorithm uses optimal sub-structures. By this, we mean that to calculate the maximum subarray ending at a particular position, we use a related, smaller subproblem (the maximum subarray ending at the previous position). For every index we check for the maximum sum subarray that ends at that index and take that forward for processing at next index.<br>

The time complexity of Kadane's algorithm is O(n).



