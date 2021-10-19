//Palindrome String link- https://practice.geeksforgeeks.org/problems/palindrome-string0817/1

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S)
    {
       for(int i=0;i<S.length()/2;i++)
       {
         if( S.charAt(i)!=S.charAt(S.length()-i-1))
         return 0;
       }
       return 1;
    }
};
