# [ Count set bits ](https://practice.geeksforgeeks.org/problems/set-bits0143/1)
## Given a positive integer N, print count of set bits in it. 
### Example 1:
**Input:**
N = 6
**Output:**
2

### Example 2:
**Input:**
N = 8
**Output:**
1

### Solution in C++:
```      
int setBits(int N) {
    int count = 0;
    while(N!=0)
    {
        if((N&1)==1) count++;
        N = N>>1;
    }
    return count;
}
```