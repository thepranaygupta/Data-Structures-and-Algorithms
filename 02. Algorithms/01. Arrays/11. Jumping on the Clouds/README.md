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

## Jumping on the Clouds: Revisited
## https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem

```java
public static void jumpingOnClouds(int c[],int k)
{
    int curr=0;
    int e=100;
    int len=c.length;
    do{
        curr=(curr+k)%len;
        e--;
        if(c[curr]==1)
            e-=2;
    }while(curr!=0);
    System.out.println(e);
}
```
