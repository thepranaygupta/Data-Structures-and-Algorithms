// https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }
        jumpingOnClouds(c, k);
    }
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
}
