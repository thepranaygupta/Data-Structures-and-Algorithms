## 509. Fibonacci Number
## https://leetcode.com/problems/fibonacci-number/

### Time Complexity: O(2^N)
### Auxiliary Space Complexity: O(N)
```java
class Solution {
    public int fib(int n) {
        if (n < 2)
		return n;
	return (fib(n - 1) + fib(n - 2));
    }
}
```

## Print Fibonacci Number Series upto N
```java
public class Fibonacci {

	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i <= n; i++)
			System.out.println(fibo(i));
	}

	static int fibo(int n) {
		if (n < 2) {
			return n;
		}
		return (fibo(n - 1) + fibo(n - 2));
	}
}
```
