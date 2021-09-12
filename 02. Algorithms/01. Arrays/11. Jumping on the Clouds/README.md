## Jumping on the Clouds
## https://www.hackerrank.com/challenges/jumping-on-the-clouds/


```java
int jumps = 0;
for(int i = 0; i < n-1; i++){
    if( i  + 2 < n && c[i + 2] == 0){
        i++;
    }
    jumps++;
}
System.out.println(jumps);
```
