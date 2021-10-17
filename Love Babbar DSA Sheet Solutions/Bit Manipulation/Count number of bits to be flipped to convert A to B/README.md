# [Count number of bits to be flipped to convert A to B ](https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1)
## You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.
### Example 1:
**Input:**
A = 10, B = 10
**Output:**
4

### Example 2:
**Input:**
A = 20, B = 25
**Output:**
3

### Solution in C++:
```      
// Function to find number of bits needed to be flipped to convert A to B
    int countBitsFlip(int a, int b){
        int count = 0;
		int x = a ^ b;
		while (x > 0) {
			x = x & (x - 1);
			count++;
		}
		return count;  
    }
```