//time: complexity 0(logN)
//Brian Kernighan's Algorithm:

class Solution {
    static int setBits(int N) {
       int c=0;
       while(N!=0)
       {
           N=N&(N-1);
           c++;
       }
       return c;
    
    }
}
