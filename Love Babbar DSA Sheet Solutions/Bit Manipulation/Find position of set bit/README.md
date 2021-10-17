# [ Find position of set bit ](https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1)
## Given a number N having only one ‘1’ and all other ’0’s in its binary representation, find position of the only set bit. If there are 0 or more than 1 set bit the answer should be -1. Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.
### Example 1:
**Input:**
N = 2
**Output:**
2

### Example 2:
**Input:**
N = 5
**Output:**
-1

### Solution in C++:
```      
int findPosition(int n) {
    int pos = 0;
    if(n<=0)    return -1;;
    if((n&(n-1))==0)
    {
        int i = 1;
        while(n!=0)
        {
            n=n>>1;
            pos++;
        }
        return pos;
    }
    else return -1;
}
```
