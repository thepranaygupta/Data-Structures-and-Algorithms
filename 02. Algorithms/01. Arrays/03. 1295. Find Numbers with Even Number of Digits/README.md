## 1295. Find Numbers with Even Number of Digits

https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

```java
class Solution {
    public int findNumbers(int[] arr) {
        int length = arr.length;
        int evencount = 0;
        for(int element: arr){
            int digitcount = 0;
            if(element < 0)
                element *= -1;
            while(element > 0){
                digitcount++;
                element /= 10;
            }
            if(digitcount%2 == 0)
                evencount++;
        }
        return evencount;
    }
}
```
