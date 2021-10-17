/******************************************************************************

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character   [ case (i-1,j) ]
Delete a character   [ case (i,j-1) ] 
Replace a character  [ case (i-1,j-1)]

*******************************************************************************/

import java.util.*;
public class Recursion
{
    private int minDistance(String s1,String s2,int i,int j){
        if(i==0 && j==0) return 0;
        if(i==0) return j;
        if(j==0) return i;
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return minDistance(s1,s2,i-1,j-1);
        } else {
            return 1+Math.min(
                    minDistance(s1,s2,i-1,j),Math.min(
                                                minDistance(s1,s2,i,j-1),
                                                minDistance(s1,s2,i-1,j-1)
                                                )
                            );
        }
    }
    private int recursiveApproach(String word1, String word2){
        if(word1.equals("") || word2.equals(""))
            return Math.max(word2.length(),word1.length());
        return minDistance(word1,word2,word1.length(),word2.length());
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String word1 =  sc.next();
	    String word2 = sc.next();
	    Recursion ob = new Recursion();
	    System.out.println(ob.recursiveApproach(word1,word2));
	}
}
