## 1672. Richest Customer Wealth

https://leetcode.com/problems/richest-customer-wealth/

## Approach 1:
```java
class Solution {
    public int maximumWealth(int[][] arr) {
        int maxWealth = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int iwealth = 0;
            for(int j = 0; j < arr[i].length; j++){
                iwealth += arr[i][j];
            }
            if(iwealth > maxWealth)
                maxWealth = iwealth;
        }
        return maxWealth;
    }
}
```

## Approach 2: using for-each loop

```java
class Solution {
    public int maximumWealth(int[][] arr) {
        int maxWealth = Integer.MIN_VALUE;
        for(int[] person: arr){
            int wealth = 0;
            for(int bank: person){
                wealth += bank;
            }
            if(wealth > maxWealth)
                maxWealth = wealth;
        }
        return maxWealth;
    }
}
```
