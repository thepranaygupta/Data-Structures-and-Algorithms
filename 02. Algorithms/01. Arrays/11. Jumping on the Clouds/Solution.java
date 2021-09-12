import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }
        int jumps = 0;
        for(int i = 0; i < n-1; i++){
            jumps++;
            if( i  + 2 < n && c[i + 2] == 0){
                i++;
            }
        }
        System.out.println(jumps);
    }
}
