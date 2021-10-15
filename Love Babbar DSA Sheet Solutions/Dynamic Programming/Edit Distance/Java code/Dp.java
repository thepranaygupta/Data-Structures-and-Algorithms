/******************************************************************************

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character   [ case (i-1,j) ]
Delete a character   [ case (i,j-1) ] 
Replace a character  [ case (i-1,j-1)]

*******************************************************************************/
import java.util.*;

public class Dp
{
    private int bottomUpDP(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0 && j==0)
                    dp[i][j] = 0;
                else if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                } else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
        
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String word1 =  sc.next();
	    String word2 = sc.next();
	    Dp ob = new Dp();
	    System.out.println(ob.bottomUpDP(word1,word2));
	}
}
